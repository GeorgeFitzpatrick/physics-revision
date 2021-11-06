package com.georgefitzpatrick.revision.physics.views.chapter;

import com.georgefitzpatrick.revision.physics.data.entity.Chapter;
import com.georgefitzpatrick.revision.physics.data.entity.SubChapter;
import com.georgefitzpatrick.revision.physics.data.service.ChapterService;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.*;
import com.vaadin.flow.theme.Theme;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

@Theme(themeFolder = "physicsrevision")
@Route("chapters/:chapter")
@Tag("chapter-view")
@JsModule("./views/physicsrevision/chapter-view.ts")
public class ChapterView extends LitTemplate implements HasComponents, HasDynamicTitle, BeforeEnterObserver, RouterLayout {

    private final RouterTabs tabs;
    private final ChapterService chapterService;

    @Id("title")
    private H2 title;

    @Id("subtitle")
    private Paragraph subtitle;

    @Id("layout")
    private HorizontalLayout layout;

    private Chapter chapter;

    @Autowired
    public ChapterView(ChapterService chapterService) {
        tabs = new RouterTabs();
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.setMaxWidth(25, Unit.PERCENTAGE);
        layout.add(tabs);

        this.chapterService = chapterService;
    }

    @Override
    public String getPageTitle() {
        return String.format("%s | Physics Revision", chapter.getTitle());
    }

    @Override
    public void beforeEnter(@NotNull BeforeEnterEvent event) {
        var chapterId = event.getRouteParameters().get("chapter").map(Long::parseLong).get();
        chapter = chapterService.findById(chapterId);

        var subChapterPresent = event.getRouteParameters().get("sub-chapter").isPresent();
        if (!subChapterPresent) {
            var chapterParam = new RouteParam("chapter", chapter.getId().toString());
            var subChapter = chapter.getSubChapters().stream().findFirst().get();
            var subChapterParam = new RouteParam("sub-chapter", subChapter.getId().toString());
            var params = new RouteParameters(chapterParam, subChapterParam);
            event.forwardTo(SubChapterView.class, params);
            return;
        }

        title.setText(chapter.getTitle());
        subtitle.setText("Physics revision");

        updateTabs(chapter);
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        if (content == null)
            return;

        layout.getElement().appendChild(content.getElement());
    }

    @Override
    public void removeRouterLayoutContent(HasElement content) {
        if (content == null)
            return;

        layout.getElement().removeChild(content.getElement());
    }

    private RouterLink subChapterLink(SubChapter subChapter) {
        var chapter = subChapter.getChapter();
        var chapterParam = new RouteParam("chapter", chapter.getId().toString());
        var subChapterParam = new RouteParam("sub-chapter", subChapter.getId().toString());
        var params = new RouteParameters(chapterParam, subChapterParam);
        return new RouterLink(subChapter.getTitle(), SubChapterView.class, params);
    }

    private void updateTabs(Chapter chapter) {
        tabs.removeAll();

        chapter.getSubChapters().forEach(subChapter -> {
            var subChapterLink = subChapterLink(subChapter);
            tabs.add(subChapterLink);
        });
    }

}

package com.georgefitzpatrick.revision.physics.views.chapters;

import com.georgefitzpatrick.revision.physics.data.service.ChapterService;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.beans.factory.annotation.Autowired;

@PWA(name = "Physics Revision", shortName = "Revision")
@Theme(themeFolder = "physicsrevision")
@PageTitle("Chapters | Physics Revision")
@Route("chapters")
@RouteAlias("")
@Tag("chapters-view")
@JsModule("./views/physicsrevision/chapters-view.ts")
public class ChaptersView extends LitTemplate implements HasComponents, HasStyle {

    private final ChapterService chapterService;

    @Id("title")
    private H2 title;

    @Id("subtitle")
    private Paragraph subtitle;

    @Autowired
    public ChaptersView(ChapterService chapterService) {
        this.chapterService = chapterService;
        this.title.setText("Chapters");
        this.subtitle.setText("Physics revision");

        updateCards();
    }

    private void updateCards() {
        chapterService.findAll().forEach(chapter -> {
            var card = new ImageCard(chapter);
            add(card);
        });
    }

}
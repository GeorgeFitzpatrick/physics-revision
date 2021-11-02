package com.georgefitzpatrick.revision.physics.views.chapter;

import com.georgefitzpatrick.revision.physics.data.AbstractEntity;
import com.georgefitzpatrick.revision.physics.data.entity.Lesson;
import com.georgefitzpatrick.revision.physics.data.entity.SubChapter;
import com.georgefitzpatrick.revision.physics.data.service.ChapterService;
import com.georgefitzpatrick.revision.physics.data.service.SubChapterService;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.Set;

@Route(value = "chapters/:chapter/sup-chapters/:sub-chapter", layout = ChapterView.class)
@Tag("sub-chapter-view")
@JsModule("./views/physicsrevision/sub-chapter-view.ts")
public class SubChapterView extends LitTemplate implements HasComponents, HasDynamicTitle, BeforeEnterObserver {

    private final ChapterService chapterService;
    private final SubChapterService subChapterService;

    @Id("chapter-title")
    private Span chapterTitle;

    @Id("sub-chapter-title")
    private Span subChapterTitle;

    @Id("page-number")
    private Anchor pageNumber;

    @Id("lessons")
    private UnorderedList lessons;

    private SubChapter subChapter;

    @Autowired
    public SubChapterView(ChapterService chapterService, SubChapterService subChapterService) {
        this.chapterService = chapterService;
        this.subChapterService = subChapterService;
    }

    @Override
    public String getPageTitle() {
        return String.format("%s | Physics Revision", subChapter.getTitle());
    }

    @Override
    public void beforeEnter(@NotNull BeforeEnterEvent event) {
        var chapterId = event.getRouteParameters().get("chapter").map(Long::parseLong).get();
        var chapter = chapterService.findById(chapterId);

        var subChapterId = event.getRouteParameters().get("sub-chapter").map(Long::parseLong).get();
        subChapter = subChapterService.findById(subChapterId);

        if (!chapter.getSubChapters().contains(subChapter))
            throw new NotFoundException();

        chapterTitle.setText(subChapter.getChapter().getTitle());
        subChapterTitle.setText(subChapter.getTitle());

        updatePageNumber(subChapter.getPageNumber());
        updateLessons(subChapter.getLessons());
    }

    private void updatePageNumber(Integer num) {
        var title = String.format("Page %s", num);
        pageNumber.setText(title);
        var url = String.format("https://www.kerboodle.com/2020/12/21/09/20/53/d235a74d-961e-439f-9bb2-e28bff6939e8/111864_content/index.html?page=%s", num);
        pageNumber.setHref(url);
    }

    private void updateLessons(@NotNull Set<Lesson> lessons) {
        this.lessons.removeAll();

        if (lessons.isEmpty()) {
            Paragraph paragraph = new Paragraph();
            paragraph.setText("Nothing to see here.");
            this.lessons.add(paragraph);
            return;
        }

        var sorted = lessons.stream().sorted(Comparator.comparingLong(AbstractEntity::getId));
        sorted.forEach(lesson -> {
            var card = new LessonCard(lesson);
            this.lessons.add(card);
        });
    }

}

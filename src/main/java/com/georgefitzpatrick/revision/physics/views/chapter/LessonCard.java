package com.georgefitzpatrick.revision.physics.views.chapter;

import com.georgefitzpatrick.revision.physics.data.entity.Lesson;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import org.jetbrains.annotations.NotNull;

import java.io.File;

@Tag("lesson-card")
@JsModule("./views/physicsrevision/lesson-card.ts")
public class LessonCard extends LitTemplate {

    @Id("file-name")
    private Paragraph fileName;

    @Id("open")
    private Anchor open;

    @Id("download")
    private Anchor download;

    public LessonCard(@NotNull Lesson lesson) {
        var path = lesson.getFilePath();
        var file = new File(path);
        var name = file.getName();

        fileName.setText(name);
        open.setHref(path);
        download.setHref(path);
        download.getElement().setAttribute("download", name);
    }

}

package com.georgefitzpatrick.revision.physics.views.chapter;

import com.georgefitzpatrick.revision.physics.data.entity.Flashcards;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import org.jetbrains.annotations.NotNull;

@Tag("flashcards-card")
@JsModule("./views/physicsrevision/flashcards-card.ts")
public class FlashcardsCard extends LitTemplate {

    @Id("title")
    private Paragraph title;

    @Id("open")
    private Anchor open;

    public FlashcardsCard(@NotNull Flashcards flashcards) {
        title.setText(flashcards.getTitle());
        open.setHref(flashcards.getUrl());
    }

}

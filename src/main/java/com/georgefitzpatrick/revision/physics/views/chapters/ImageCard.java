package com.georgefitzpatrick.revision.physics.views.chapters;

import com.georgefitzpatrick.revision.physics.data.entity.Chapter;
import com.georgefitzpatrick.revision.physics.views.chapter.ChapterView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.RouteParam;
import com.vaadin.flow.router.RouteParameters;
import org.jetbrains.annotations.NotNull;

@Tag("image-card")
@JsModule("./views/physicsrevision/image-card.ts")
public class ImageCard extends LitTemplate {

    @Id("root")
    private ListItem root;

    @Id("image")
    private Image image;

    @Id("header")
    private Span header;

    @Id("subtitle")
    private Span subtitle;

    @Id("badge")
    private Span badge;

    public ImageCard(@NotNull Chapter chapter) {
        this.image.setSrc(chapter.getModule().getImage());
        this.image.setAlt(chapter.getTitle());
        this.header.setText(chapter.getTitle());
        this.subtitle.setText("Chapter " + chapter.getId());
        this.badge.setText(chapter.getModule().getTitle());

        this.root.addClickListener((ComponentEventListener<ClickEvent<ListItem>>) listItemClickEvent -> {
            RouteParam param = new RouteParam("chapter", chapter.getId().toString());
            RouteParameters params = new RouteParameters(param);
            UI.getCurrent().navigate(ChapterView.class, params);
        });
    }

}

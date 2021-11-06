package com.georgefitzpatrick.revision.physics.data.entity;

import com.georgefitzpatrick.revision.physics.data.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "flashcards")
public class Flashcards extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    public Flashcards() {

    }

    public Flashcards(Long id, Chapter chapter, String title, String url) {
        super(id);
        this.chapter = chapter;
        this.title = title;
        this.url = url;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

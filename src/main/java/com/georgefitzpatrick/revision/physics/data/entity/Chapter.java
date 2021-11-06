package com.georgefitzpatrick.revision.physics.data.entity;

import com.georgefitzpatrick.revision.physics.data.AbstractEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chapters")
public class Chapter extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chapter_id")
    private Set<Flashcards> flashcards;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chapter_id")
    private Set<SubChapter> subChapters;

    public Chapter() {

    }

    public Chapter(Long id, Module module, String title, Set<Flashcards> flashcards, Set<SubChapter> subChapters) {
        super(id);
        this.module = module;
        this.title = title;
        this.flashcards = flashcards;
        this.subChapters = subChapters;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Flashcards> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(Set<Flashcards> flashcards) {
        this.flashcards = flashcards;
    }

    public Set<SubChapter> getSubChapters() {
        return subChapters;
    }

    public void setSubChapters(Set<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

}

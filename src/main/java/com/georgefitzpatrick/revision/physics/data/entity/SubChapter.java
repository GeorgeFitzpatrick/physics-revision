package com.georgefitzpatrick.revision.physics.data.entity;

import com.georgefitzpatrick.revision.physics.data.AbstractEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sub_chapters")
public class SubChapter extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @Column(name = "title")
    private String title;

    @Column(name = "page_number")
    private Integer pageNumber;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_chapter_id")
    private Set<Lesson> lessons;

    public SubChapter() {

    }

    public SubChapter(Long id, Chapter chapter, String title, Integer pageNumber, Set<Lesson> lessons) {
        super(id);
        this.chapter = chapter;
        this.title = title;
        this.pageNumber = pageNumber;
        this.lessons = lessons;
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

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

}

package com.georgefitzpatrick.revision.physics.data.entity;

import com.georgefitzpatrick.revision.physics.data.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "lessons")
public class Lesson extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "sub_chapter_id")
    private SubChapter subChapter;

    @Column(name = "file_path")
    private String filePath;

    public Lesson() {

    }

    public Lesson(Long id, SubChapter subChapter, String filePath) {
        super(id);
        this.subChapter = subChapter;
        this.filePath = filePath;
    }

    public SubChapter getSubChapter() {
        return subChapter;
    }

    public void setSubChapter(SubChapter subChapter) {
        this.subChapter = subChapter;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}

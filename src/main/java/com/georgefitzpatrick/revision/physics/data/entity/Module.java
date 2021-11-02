package com.georgefitzpatrick.revision.physics.data.entity;

import com.georgefitzpatrick.revision.physics.data.AbstractEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "modules")
public class Module extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id")
    private Set<Chapter> chapters;

    public Module() {

    }

    public Module(Long id, String title, String image, Set<Chapter> chapters) {
        super(id);
        this.title = title;
        this.image = image;
        this.chapters = chapters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }

}

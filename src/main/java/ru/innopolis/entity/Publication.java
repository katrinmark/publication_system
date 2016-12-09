package ru.innopolis.entity;

import javax.persistence.*;

/**
 * This class is used to transfer data to publication table
 */
@Entity
@Table
public class Publication extends BaseEntity {
    @ManyToOne
    @JoinColumn(name="authorId")
    private Profile profile;
    private String title;
    private String content;

    public Publication() {
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTille(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

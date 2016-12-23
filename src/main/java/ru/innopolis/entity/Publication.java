package ru.innopolis.entity;

import javax.persistence.*;

/**
 * This class is used to transfer data to publication table
 */
@Entity
@Table
public class Publication extends BaseEntity {
    @Column
    private String title;
    @Column(columnDefinition = "varchar(1000)")
    private String content;

    @ManyToOne
    @JoinColumn(name="profile_id")
    private Profile profile;

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

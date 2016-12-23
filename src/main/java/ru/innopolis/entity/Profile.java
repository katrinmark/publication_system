package ru.innopolis.entity;

import javax.persistence.*;

/**
 * This class is used to transfer data to profile table
 */
@Entity
@Table(name = "profile")
public class Profile extends BaseEntity{
    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private String username;

    @OneToOne
    private User user;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


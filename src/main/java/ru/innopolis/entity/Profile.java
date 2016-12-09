package ru.innopolis.entity;

import javax.persistence.*;

/**
 * This class is used to transfer data to user table
 */
@Entity
@Table(name = "profile")
public class Profile extends BaseEntity{
    private String firstName;
    private String secondName;
    private String email;

    @OneToOne
    @JoinColumn(name="id")
    private User user;

    public Profile() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


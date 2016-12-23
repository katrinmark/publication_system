package ru.innopolis.entity;


import javax.persistence.*;

/**
 * Created by Ekaterina on 09.12.2016.
 */
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column
    private String username;
    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "enabled", columnDefinition = "boolean default true")
    private boolean enabled;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

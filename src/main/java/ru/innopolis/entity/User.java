package ru.innopolis.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ekaterina on 09.12.2016.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private Long id;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name="role_id", nullable=false, columnDefinition="VARCHAR(250 default 'ROLE_USER'")
    private Role role;

    private boolean enabled;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

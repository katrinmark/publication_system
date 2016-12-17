package ru.innopolis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ekaterina on 06.12.2016.
 */
@Entity
@Table
public class Role extends BaseEntity{
    @Column(columnDefinition = "varchar(250) default 'ROLE_USER'", unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

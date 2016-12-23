package ru.innopolis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class is used to transfer data to role table
 */
@Entity
@Table
public class Role extends BaseEntity{
    @Column(columnDefinition = "varchar(250)", unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

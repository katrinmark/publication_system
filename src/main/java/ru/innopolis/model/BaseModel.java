package ru.innopolis.model;

import java.io.Serializable;

/**
 * Created by Ekaterina on 09.12.2016.
 */
public class BaseModel implements Serializable{
    private static final long serialVersionUID = -7475875841566134198L;
    private Long id;
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

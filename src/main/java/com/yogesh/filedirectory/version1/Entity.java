package com.yogesh.filedirectory.version1;

import lombok.*;

import java.time.*;

@Getter
public abstract class Entity {
    @Setter
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private LocalDateTime lastAccessed;
    private int size;
    private Entity parent;
    private boolean isParent;
    private String createdBy;
    private String updatedBy;

    public Entity(String name) {
        this.name = name;
    }

    public Entity(String name, Entity parent) {
        this.name = name;
        this.parent = parent;
    }
}

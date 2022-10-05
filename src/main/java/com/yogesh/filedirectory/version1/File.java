package com.yogesh.filedirectory.version1;

import lombok.*;

public class File extends Entity {
    private final String content;
    @Getter
    private final String type;

    public File(String name, String content, String type) {
        super(name);
        this.content = content;
        this.type = type;
    }

    public File(String name, String content, Entity parent, String type) {
        super(name, parent);
        this.content = content;
        this.type = type;
    }

    public void rename(String fileName) {
        this.setName(fileName);
    }

    public void delete() {

    }
}

package com.yogesh.filedirectory.version2;

import lombok.*;

@Getter
@ToString
public class File extends Entry {
    private String content;
    @Setter
    private String extension;

    public File(String name) {
        super(name);
    }

    @Override
    public int getSize() {
        return content.length();
    }

    public File(final String name, final String content) {
        super(name);
        this.content = content;
    }

    @Override
    boolean getDirectory() {
        return false;
    }
}

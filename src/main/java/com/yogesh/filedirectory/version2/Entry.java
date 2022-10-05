package com.yogesh.filedirectory.version2;

import lombok.*;

@ToString
public abstract class Entry {
    @Getter
    private String name;
    @Getter
    private Entry parent;
    private int size;

    public Entry(final String name) {
        this.name = name;
    }

    abstract int getSize();

    abstract boolean getDirectory();
    // some other metadata
}

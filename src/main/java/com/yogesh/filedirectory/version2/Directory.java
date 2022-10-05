package com.yogesh.filedirectory.version2;

import lombok.*;

import java.util.*;

@Getter
public class Directory extends Entry {
    List<Entry> entryList = new ArrayList<>();

    public Directory(final String name) {
        super(name);
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : entryList) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    boolean getDirectory() {
        return true;
    }

    public void addEntry(final Entry entry) {
        entryList.add(entry);
    }
}

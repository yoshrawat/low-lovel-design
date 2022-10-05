package com.yogesh.filedirectory.version2;

import com.yogesh.filedirectory.version2.filter.*;

import java.util.*;

public class FileSearcher {
    private final FileFilter fileFilter;

    public FileSearcher(final FileFilter fileFilter) {
        this.fileFilter = fileFilter;
    }

    public List<File> search(Directory directory, SearchParams searchParams) {
        List<File> resultList = new ArrayList<>();

        Deque<Directory> directories = new ArrayDeque<>();
        directories.add(directory);

        while (!directories.isEmpty()) {
            Directory dir = directories.poll();

            for (Entry entry : dir.getEntryList()) {
                if (entry.getDirectory()) {
                    directories.add((Directory) entry);
                } else {
                    File file = (File) entry;
                    if (fileFilter.isValid(file, searchParams)) {
                        resultList.add(file);
                    }
                }
            }
        }
        return resultList;
    }
}

package com.yogesh.filedirectory.version1;

import java.util.*;


public class Directory extends Entity {
    private Map<String, Directory> directoryList;
    private Map<String, File> fileList;

    public Directory(String folderName) {
        super(folderName);
    }

    public Directory(String folderName, Directory directory) {
        super(folderName, directory);
        this.directoryList = new HashMap<>();
    }

    public void createFile(final String filename, final String content) {
        File file = new File(filename, content, this, "xml");
        if (fileList == null)
            fileList = new HashMap<>();
        fileList.put(filename, file);
    }

    public void createFolder(final String folderName) {
        Directory directory = new Directory(folderName, this);
        this.directoryList.put(folderName, directory);
    }

    public boolean deleteFile(final String fileName) {
        if (this.fileList.containsKey(fileName)) {
            this.fileList.remove(fileName);
            return true;
        }
        return false;
    }

    public void deleteFolder(final String folderName) {
        if (this.directoryList.containsKey(folderName)) {
            this.directoryList.remove(folderName);
        }
    }
}

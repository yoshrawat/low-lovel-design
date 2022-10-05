package com.yogesh.filedirectory.version2;

import com.yogesh.filedirectory.version2.filter.*;

public class Main {
    public static void main(String[] args) {
        SearchParams params = new SearchParams();
        params.setExtension("json");
        params.setMinSize(2);
        params.setMaxSize(100);

        File xmlFile = new File("aaa.xml", "aaa");
        xmlFile.setExtension("xml");

        File txtFile = new File("bbb.txt", "bbb");
        txtFile.setExtension("txt");

        File jsonFile = new File("ccc.json", "ccc");
        jsonFile.setExtension("json");

        Directory dir1 = new Directory("dir1");
        dir1.addEntry(txtFile);
        dir1.addEntry(xmlFile);

        Directory dir0 = new Directory("dir0");
        dir0.addEntry(jsonFile);
        dir0.addEntry(dir1);
        FileFilter fileFilter = new FileFilter();
        FileSearcher searcher = new FileSearcher(fileFilter);

        System.out.println(searcher.search(dir0, params));
    }
}

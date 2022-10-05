package com.yogesh.filedirectory.version1;

import java.util.*;

public class FindCommand {
    public static void main(String[] args) {
        List<File> fileList = new ArrayList<>();
    }
//    public List<File> findWithFilters(File directory, List<Criteria> filters) {
//        if (!directory.isDirectory) {
//            return new NotADirectoryException();
//        }
//        List<File> output = new ArrayList<>();
//        findWithFilters(directory, filters, output);
//        return output;
//    }
//
//    private void findWithFilters(File directory, List<Criteria> filters, List<File> output) {
//        if (directory.children == null) {
//            return;
//        }
//        for (File file : directory.children) {
//            if (file.isDirectory) {
//                findWithFilters(file, filters, output);
//            } else {
//                boolean selectFile = true;
//                for (Filter filter : filters) {
//                    if (!filter.apply(file)) {
//                        selectFile = false;
//                    }
//                }
//                if (selectFile) {
//                    output.add(file);
//                }
//            }
//        }
//    }
}

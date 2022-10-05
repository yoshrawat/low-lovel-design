package com.yogesh.filedirectory.version2.filter;


import com.yogesh.filedirectory.version2.*;

import java.util.*;

public class FileFilter {
    private final List<Filter> filters = new ArrayList<>();

    public FileFilter() {
        filters.add(new NameFilter());
        filters.add(new MaxSizeFilter());
        filters.add(new MinSizeFilter());
        filters.add(new ExtensionFilter());
    }

    public boolean isValid(File file, SearchParams params) {
        for (Filter filter : filters) {
            if (!filter.isValid(params, file)) {
                return false;
            }
        }

        return true;
    }
}

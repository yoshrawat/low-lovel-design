package com.yogesh.filedirectory.version2.filter;

import com.yogesh.filedirectory.version2.*;

public class NameFilter implements Filter {

    @Override
    public boolean isValid(SearchParams params, File file) {
        if (params.getName() == null) {
            return true;
        }

        return file.getName().equals(params.getName());
    }

}
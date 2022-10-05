package com.yogesh.filedirectory.version2.filter;

import com.yogesh.filedirectory.version2.*;

public class MaxSizeFilter implements Filter {

    @Override
    public boolean isValid(SearchParams params, File file) {
        if (params.getMaxSize() == null) {
            return true;
        }

        return file.getSize() <= params.getMaxSize();
    }

}

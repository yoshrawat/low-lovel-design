package com.yogesh.filedirectory.version2.filter;

import com.yogesh.filedirectory.version2.*;

public class MinSizeFilter implements Filter {

    @Override
    public boolean isValid(SearchParams params, File file) {
        if (params.getMinSize() == null) {
            return true;
        }

        return file.getSize() >= params.getMinSize();
    }

}

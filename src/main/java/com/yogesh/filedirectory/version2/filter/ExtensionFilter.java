package com.yogesh.filedirectory.version2.filter;

import com.yogesh.filedirectory.version2.*;

public class ExtensionFilter implements Filter {

    @Override
    public boolean isValid(SearchParams params, File file) {
        if (params.getExtension() == null) {
            return true;
        }

        return file.getExtension().equals(params.getExtension());
    }

}

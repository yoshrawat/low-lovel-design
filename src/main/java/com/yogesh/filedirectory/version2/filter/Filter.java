package com.yogesh.filedirectory.version2.filter;

import com.yogesh.filedirectory.version2.*;

public interface Filter {
    boolean isValid(SearchParams searchParams, File File);
}

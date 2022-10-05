package com.yogesh.filedirectory.version1.filter;

import com.yogesh.filedirectory.version1.*;

import java.util.*;
import java.util.stream.*;

public class MinSizeCriteria implements Criteria {
    private final int size;

    public MinSizeCriteria(final int size) {
        this.size = size;
    }

    @Override
    public List<File> entityCriteria(List<File> entityList) {
        return entityList.stream().filter(entity -> entity.getSize() <= this.size).collect(Collectors.toList());
    }
}

package com.yogesh.filedirectory.version1.filter;

import com.yogesh.filedirectory.version1.*;

import java.util.*;
import java.util.stream.*;

public class TypeCriteria implements Criteria {
    private final String type;

    public TypeCriteria(final String type) {
        this.type = type;
    }

    @Override
    public List<File> entityCriteria(List<File> entityList) {
        return entityList.stream().filter(entity -> entity.getType().equals(type)).collect(Collectors.toList());
    }
}

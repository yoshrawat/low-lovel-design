package com.yogesh.filedirectory.version1.filter;

import com.yogesh.filedirectory.version1.*;

import java.util.*;

public interface Criteria {
    List<File> entityCriteria(List<File> entityList);
}

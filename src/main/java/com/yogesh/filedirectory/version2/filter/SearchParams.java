package com.yogesh.filedirectory.version2.filter;

import lombok.*;

@Getter
@Setter
public class SearchParams {
    private String extension;
    private Integer minSize;
    private Integer maxSize;
    private String name;
}

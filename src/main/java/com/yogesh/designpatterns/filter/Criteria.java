package com.yogesh.designpatterns.filter;

import java.util.*;

public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}

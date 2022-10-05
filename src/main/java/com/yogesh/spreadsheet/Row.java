package com.yogesh.spreadsheet;

import lombok.*;

import java.util.*;

@Getter
@Setter
public class Row {
    private Map<Integer, Cell> cols;

    public Row(int col) {
        cols = new HashMap<>();
        for (int j = 1; j <= col; j++) {
            cols.put(j, null);
        }
    }
    public void addColumnToLeft(final Cell cell) {

    }

    public void addColumnToRight(final Cell cell) {

    }
}

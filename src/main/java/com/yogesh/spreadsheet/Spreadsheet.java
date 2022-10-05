package com.yogesh.spreadsheet;

import lombok.*;

import java.util.*;

@Getter
@Setter
public class Spreadsheet {
    private Map<Integer, Row> rows;

    public Spreadsheet(int row, int col) {
        rows = new HashMap<>();

        for (int i = 1; i <= row; i++) {
            rows.put(i, new Row(col));
        }
    }

    public void addRowTop(final Map<Integer, Row> row) {

    }

}

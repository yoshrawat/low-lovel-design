package com.yogesh.chess;

import lombok.*;

@Getter
public class Position {
    private int x;
    private int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}

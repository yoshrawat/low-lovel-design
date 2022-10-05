package com.yogesh.tictactoe.model;

import lombok.*;

@Getter
public class Move {
    private int x;
    private int y;

    public Move(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}

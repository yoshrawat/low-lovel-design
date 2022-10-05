package com.yogesh.snakeladder;

import lombok.*;

@Getter
@Setter
public class Player {
    private String name;
    private int position;

    public Player(final String name, final int position) {
        this.name = name;
        this.position = position;
    }
}

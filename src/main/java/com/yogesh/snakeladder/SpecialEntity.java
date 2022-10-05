package com.yogesh.snakeladder;

import lombok.*;

@Getter
@Setter
public abstract class SpecialEntity {
    private int startPosition;
    private int endPosition;

    public SpecialEntity(final int startPosition, final int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}

package com.yogesh.chess;

import com.yogesh.chess.piece.*;
import lombok.*;

@Getter
public class Move {
    private String id;
    private Position startPosition;
    private Position finalPosition;
    private Piece piece;

    public Move(final String id, final Position startPosition, final Position finalPosition, final Piece piece) {
        this.id = id;
        this.startPosition = startPosition;
        this.finalPosition = finalPosition;
        this.piece = piece;
    }
}

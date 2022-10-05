package com.yogesh.chess;

import com.yogesh.chess.piece.*;
import lombok.*;

@Getter
public class Cell {
    private Position position;
    private Piece piece;

    public Cell(final Position position) {
        this.position = position;
    }

    public void Piece(final Piece piece) {
        this.piece = piece;
    }

    public void clearCell() {
        this.piece = null;
    }
}

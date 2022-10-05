package com.yogesh.chess.piece;

import com.yogesh.chess.*;
import lombok.*;

@Getter
public abstract class Piece {
    private boolean isWhite;
    @Setter
    private Position currentPosition;
    @Setter
    private boolean isKilled;

    public Piece(boolean color, Position currPosition) {
        this.isWhite = color;
        this.currentPosition = currPosition;
        isKilled = Boolean.FALSE;
    }

    public abstract PieceType PieceType();

    public abstract boolean isValid(final Position startPosition, final Position endPosition);
}

package com.yogesh.chess.piece;

import com.yogesh.chess.*;

public class King extends Piece {

    public King(final boolean color, final Position currPosition) {
        super(color, currPosition);
    }

    @Override
    public PieceType PieceType() {
        return PieceType.KING;
    }

    @Override
    public boolean isValid(Position startPosition, Position endPosition) {
        return true;
    }
}

package com.yogesh.chess;

import com.yogesh.chess.piece.*;

public class Board {
    private Cell[][] cell;
    private final int row;
    private final int col;

    public Board(final int x, final int y) {
        this.row = x;
        this.col = y;
        cell = new Cell[x][y];
    }

    public boolean makeMove(Position startPosition, Position finalPosition) {
        int x = startPosition.getX();
        int y = startPosition.getY();
        Piece currentPiece = cell[x][y].getPiece();
        return true;
    }
}

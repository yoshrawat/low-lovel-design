package com.yogesh.tictactoe.model;

import lombok.*;

import java.util.*;

import static com.yogesh.tictactoe.model.Constants.*;

@Data
public class Board {
    private PieceEnum[][] cell;
    public static int TOTAL_MOVES;

    public Board() {
        cell = new PieceEnum[TOTAL_ROWS][TOTAL_COLS];
        TOTAL_MOVES = TOTAL_ROWS * TOTAL_COLS;
        initializeBoard();
    }

    private void initializeBoard() {
        for (PieceEnum[] rows : cell) {
            Arrays.fill(rows, PieceEnum.EMPTY);
        }
    }

    public boolean isValid(int[] cord) {
        return cell[cord[0]][cord[1]] == PieceEnum.EMPTY;
    }

    public boolean makeMove(Player player, int[] cord) {
        cell[cord[0]][cord[1]] = player.getPieceEnum();
        if (checkVertical(cord[1], player.getPieceEnum()) ||
                checkHorizontal(cord[0], player.getPieceEnum()) ||
                checkDiagnal(player.getPieceEnum()) ||
                checkAntiDiagnal(player.getPieceEnum())
        )
            return true;
        return false;
    }

    private boolean checkVertical(int col, PieceEnum pieceEnum) {
        for (int j = 0; j < cell[0].length; j++) {
            if (cell[j][col] != pieceEnum)
                return false;
        }
        return true;
    }

    private boolean checkHorizontal(int row, PieceEnum pieceEnum) {
        for (int j = 0; j < cell[0].length; j++) {
            if (cell[row][j] != pieceEnum)
                return false;
        }
        return true;
    }

    private boolean checkDiagnal(PieceEnum pieceEnum) {
        for (int row = 0; row < cell.length; row++) {
            if (cell[row][row] != pieceEnum)
                return false;
        }
        return true;
    }

    private boolean checkAntiDiagnal(PieceEnum pieceEnum) {
        for (int row = 0; row < cell.length; row++) {
            if (cell[row][cell[0].length - row - 1] != pieceEnum)
                return false;
        }
        return true;
    }
}

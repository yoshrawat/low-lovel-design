package com.yogesh.tictactoe.model;

import lombok.*;

import java.util.*;

public class Player {
    @Getter
    private final String name;
    @Getter
    private final PieceEnum pieceEnum;
    private final List<Move> moveList;

    public Player(String name, PieceEnum circle) {
        this.name = name;
        pieceEnum = circle;
        moveList = new ArrayList<>();
    }

    public void addMove(final Move move) {
        this.moveList.add(move);
    }
}

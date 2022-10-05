package com.yogesh.chess;

import lombok.*;

import java.util.*;

public class Player {
    @Getter
    private String id;
    @Getter
    private List<Move> moveList;

    public Player(final String id) {
        this.id = id;
        moveList = new ArrayList<>();
    }

    public void addMove(final Move move) {
        moveList.add(move);
    }
}

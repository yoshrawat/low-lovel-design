package com.yogesh.snakeladder;

import lombok.*;

import java.util.*;


public class Board {
    @Getter
    private final int dimension;
    @Getter
    private Map<Integer, SpecialEntity> specialEntities;

    public Board(final int dimension) {
        this.dimension = dimension;
    }

    public void printBoard() {

    }

    public int getTotalCells() {
        return this.dimension * this.dimension;
    }

    public void addSpecialEntity(SpecialEntity specialEntity) {
        int startPosition = specialEntity.getStartPosition();
        specialEntities.put(startPosition, specialEntity);
    }

    public boolean hasSpecialEntity(int position) {
        return specialEntities.containsKey(position);
    }

    public SpecialEntity getSpecialEntity(int position) {
        if (hasSpecialEntity(position))
            return specialEntities.get(position);

        return null;
    }
}

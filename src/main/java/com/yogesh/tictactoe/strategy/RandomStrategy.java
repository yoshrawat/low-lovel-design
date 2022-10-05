package com.yogesh.tictactoe.strategy;

public class RandomStrategy implements GameStrategy {
    private int x;
    private int y;

    public RandomStrategy(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getNextPos() {
        int x = (int) (Math.random() * this.x + 1);
        int y = (int) (Math.random() * this.y + 1);
        return new int[]{x, y};
    }
}

package com.yogesh.snakeladder;

public class Dice {
    private final int maxValue;

    public Dice(final int maxValue) {
        this.maxValue = maxValue;
    }

    public int roll() {
        return (int) (Math.random() * maxValue + 1);
    }
}

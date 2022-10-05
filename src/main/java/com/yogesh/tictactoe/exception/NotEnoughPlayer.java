package com.yogesh.tictactoe.exception;

public class NotEnoughPlayer extends RuntimeException {
    public NotEnoughPlayer(final String message) {
        super(message);
    }
}

package com.yogesh.chess.exception;

public class NotEnoughPlayer extends RuntimeException {
    public NotEnoughPlayer(final String message) {
        super(message);
    }
}

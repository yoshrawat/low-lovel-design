package com.yogesh.flightbooking.exception;

public class InValidAirLineException extends RuntimeException {
    public InValidAirLineException(String message) {
        super(message);
    }
}

package com.yogesh.loggingsystem.v1;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int logLevel, String message) {
        if (ERROR == logLevel) {
            System.out.println(message);
        } else {
            super.log(logLevel, message);
        }
    }
}

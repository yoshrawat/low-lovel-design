package com.yogesh.loggingsystem.v1;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int logLevel, String message) {
        if (DEBUG == logLevel) {
            System.out.println(message);
        } else {
            super.log(logLevel, message);
        }
    }
}

package com.yogesh.loggingsystem.v1;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int logLevel, String message) {
        if (INFO == logLevel) {
            System.out.println(message);
        } else {
            super.log(logLevel, message);
        }
    }
}

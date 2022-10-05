package com.yogesh.loggingsystem.v1;

public abstract class LogProcessor {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;
    private final LogProcessor nextLogProcessor;

    public LogProcessor(final LogProcessor logProcessor) {
        this.nextLogProcessor = logProcessor;
    }

    public void log(int logLevel, String message) {
        if (null != nextLogProcessor) {
            nextLogProcessor.log(logLevel, message);
        }
    }
}

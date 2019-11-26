package com.moodanalyser;

public class MoodAnalysisException extends Exception {

    ExceptionType type;

    public MoodAnalysisException(ExceptionType type) {
        this.type = type;
    }

    public MoodAnalysisException(String message) {
        super(message);
    }

    public MoodAnalysisException(String message, ExceptionType type) {
        super(message);
    }

    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY
    }
}

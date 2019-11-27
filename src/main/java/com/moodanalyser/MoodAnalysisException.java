package com.moodanalyser;

public class MoodAnalysisException extends Exception {

    ExceptionType type;

    public MoodAnalysisException(ExceptionType type) {
        super(type.toString());
        this.type = type;

    }

    public MoodAnalysisException(String message) {
        super(message);
    }

    public MoodAnalysisException(String message, ExceptionType type) {
        super(message);
    }

    public MoodAnalysisException(ExceptionType noSuchField, String s) {
        super(String.valueOf(noSuchField));
    }

    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS,
        OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE,NO_ACCESS
    }
}

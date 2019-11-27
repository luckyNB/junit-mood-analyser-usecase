package com.moodanalyser;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }



    public MoodAnalyser() {

    }

    public String analyzeMood() throws MoodException {
        try {
            if (message == null) {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            throw new MoodException("Please Enter Proper Mood");
        }
        return null;
    }

    public void analyzeMood(MoodAnalyser moodAnalyser) throws MoodAnalysisException {
        if (moodAnalyser == null)
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL);
    }

    public String analyzeMood(String mood) throws MoodAnalysisException {
        if (mood.isEmpty()) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY);
        }
        return mood;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else
            return false;
    }

}
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
            if (message.contains("ANY"))
                return "HAPPY";
            if (message.contains("SAD"))
                return "SAD";
            if (message.contains(""))
                return "HAPPY";
            else
                return "SAD";
        } catch (NullPointerException e) {
            throw new MoodException("Please Enter Proper Mood");
        }
    }
}
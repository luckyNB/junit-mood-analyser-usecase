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
          if (message==null){
              return  "HAPPY";
          }
        } catch (NullPointerException e) {
            throw new MoodException("Please Enter Proper Mood");
        }
    return null;
    }

}
package com.moodanalyser;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser(String message) {
        this.message = message;

    }

    public MoodAnalyser() {

    }

    public String analyzeMood() {
          if (message.contains(""))
              return "HAPPY";
          else
              return "SAD";


    }
}
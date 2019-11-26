package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_should_Return_HappyOrSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        String currentMood=moodAnalyser.analyzeMood();
        Assert.assertEquals("HAPPY",currentMood);
    }

    @Test
    public void givenMessageSadMood_Should_ReturnSad() {
        MoodAnalyser moodAnalyser=new MoodAnalyser(" I am in SAD Mood");
        String currentMood=moodAnalyser.analyzeMood();
        Assert.assertEquals("SAD",currentMood);
    }
}

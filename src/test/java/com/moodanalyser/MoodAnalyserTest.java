package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void givenMessage_should_Return_HappyOrSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        String currentMood = null;
        try {
            currentMood = moodAnalyser.analyzeMood();
        } catch (MoodException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", currentMood);
    }

    @Test
    public void givenMessageSadMood_Should_ReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(" I am in SAD Mood");
        String currentMood = null;
        try {
            currentMood = moodAnalyser.analyzeMood();
        } catch (MoodException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", currentMood);
    }

    @Test
    public void givenMessageAnyMood_Should_returnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in ANY Mood");
        String currentMood = null;
        try {
            currentMood = moodAnalyser.analyzeMood();
        } catch (MoodException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", currentMood);
    }

    @Test
    public void givenMessageNull_Should_ThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String currentMood = null;
        try {
            currentMood = moodAnalyser.analyzeMood();
        } catch (MoodException e) {
            Assert.assertEquals("Please Enter Proper Mood", e.getMessage());
        }
    }

    @Test
    public void givenMessageNull_Should_ReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            String currentMood = moodAnalyser.analyzeMood();
            Assert.assertEquals("HAPPY", currentMood);
        } catch (MoodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMood_Should_ReturnException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyzeMood((MoodAnalyser) null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenEmptyMood_Should_ReturnException() {
        MoodAnalyser moodAnalyser=new MoodAnalyser();
        try {
            moodAnalyser.analyzeMood("");
        }catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }
}

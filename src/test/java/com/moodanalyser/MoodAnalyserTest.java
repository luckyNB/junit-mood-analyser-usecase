package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    @Test
    public void givenMessage_should_Return_HappyOrSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        String currentMood = null;
        try {
            currentMood = moodAnalyser.analyzeMood();
        } catch (MoodAnalysisException e) {
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
        } catch (MoodAnalysisException e) {
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
        } catch (MoodAnalysisException e) {
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
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please Enter Proper Mood", e.getMessage());
        }
    }

    @Test
    public void givenMessageNull_Should_ReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            String currentMood = moodAnalyser.analyzeMood();
            Assert.assertEquals("HAPPY", currentMood);
        } catch (MoodAnalysisException e) {
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
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        try {
            moodAnalyser.analyzeMood("");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }




    public void givenConstructorImproper_Should_ThrowMoodAnalysisException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserObject = MoodAnalyserReflection.createMoodAnalyserObject("I am in HAPPY Mood Analyser class");
            String mood = moodAnalyserObject.analyzeMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {

    public void givenHappyMessageWithReflection_Should_ReturnHappy() {
        try {
            Object myObject = MoodAnalyserReflector.createMoodAnalyzer("I am in HAPPY mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given_ImproperMethodName_Should_ThrowMoodAnalysisException() throws MoodAnalysisException {
        try {
            Object myObject = MoodAnalyserReflector.createMoodAnalyzer("I am in HAPPY mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myObject, "analyzeMoodd");
            Assert.assertEquals("HAPPY", mood);
        }
        catch (MoodAnalysisException e){

            e.printStackTrace();
        }

    }
    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        try {
            Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
            Object muObject = MoodAnalyserReflector.createMoodAnalyser(constructor, "I am in HAPPY mood");
            Assert.assertEquals(new MoodAnalyser("I am in HAPPY mood"), muObject);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_WithDefaultConstructor_ShouldReturnHappy() {
        try {
            Constructor<?> constructor = MoodAnalyserReflector.getConstructor();
            Object myObject=MoodAnalyserReflector.createMoodAnalyser(constructor);
            MoodAnalyserReflector.setFieldValue(myObject,"messge","I am in HAPPY mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

}

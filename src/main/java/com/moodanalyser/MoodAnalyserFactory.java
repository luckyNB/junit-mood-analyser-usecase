package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyserObject() throws MoodAnalysisException {

        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanalyser.MoodAnalyser1");
            Constructor<?> moodAnalyserConstructor = moodAnalyserClass.getConstructor();
            Object moodObject = moodAnalyserConstructor.newInstance();
            return (MoodAnalyser) moodObject;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("No Such Class Error");

        }
        return null;
    }

}

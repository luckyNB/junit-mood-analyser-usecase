package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {



    public static Constructor<?> getConstructor(Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            return moodAnalyzerClass.getConstructor(param);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        }
    }

    public static Object createMoodAnalyser(Constructor<?> constructor, Object... message)throws  MoodAnalysisException {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException e) {

            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE);
        }
        return null;
    }


    public static MoodAnalyser createMoodAnalyzer(String message) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyerClass = Class.forName("com.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyerClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static MoodAnalyser createMoodAnalyserObject() throws MoodAnalysisException {

        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanalyser.MoodAnalyser2");
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
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);

        }
        return null;
    }




    public static Object invokeMethod(Object moodAnalyserObject, String methodName) throws MoodAnalysisException {
        try {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Define proper method");
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "may be wrong parameters");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, "may be wrong parameters");
        }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject, fieldValue);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, "May be Issue with Data entered");
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Define proper field Name");
        }
    }

}

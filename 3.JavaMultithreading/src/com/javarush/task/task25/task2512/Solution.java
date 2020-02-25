package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.TimerTask;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> exceptionList = new ArrayList<>();
        exceptionList.add(e);
        Throwable nextThrowable = e.getCause();
        while (nextThrowable != null) {
            exceptionList.add(0, nextThrowable);
            nextThrowable = nextThrowable.getCause();
        }
        for (Throwable throwable : exceptionList) {
            System.out.println(throwable.getClass().getName() + ": " + throwable.getMessage());
        }
    }

    public static void main(String[] args) {

    }
}

package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
       //-----------------------------
//        this.handler = new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread thread, Throwable throwable) {
//                System.out.println(throwable.getMessage().replaceAll(thread.getName(), thread.getName().replaceAll(".", "*")));
//            }
//        };

//----------------------------------
        this.handler = (t, e) -> {
            String threadName = t.getName();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < threadName.length(); i++) {
                sb = sb.append('*');
            }
            String newThreadName = sb.toString();
            String message = e.getMessage().replaceAll(threadName, newThreadName);
            e = new Exception(message, e);
            System.out.println(e.getMessage());
            t.setName(newThreadName);
        };
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
         new Solution(new TimerTask() {
            @Override
            public void run() {
                throw new UnsupportedOperationException();
            }
        }).run();
    }
}
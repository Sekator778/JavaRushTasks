package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 1;

                try {
                    while (true) {
                    map.put(String.valueOf(i), "Some text for " + i);
                    Thread.sleep(500);
                i++;}
            } catch (Exception e) {
                System.out.println(String.format("[%s], thread was terminated", Thread.currentThread().getName()));
            }
        }


}

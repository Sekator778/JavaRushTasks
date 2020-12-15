package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String s : strings
        ) {
            result.add(shortener.getId(s));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long s : keys
        ) {
            result.add(shortener.getString(s));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName() + ":");
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            String nextRandomString = Helper.generateRandomString();
            strings.add(nextRandomString);
//            Helper.printMessage(nextRandomString);
        }
        Shortener shortener = new Shortener(strategy);
        Date startTime= new Date();
        Set<Long> keys = getIds(shortener, strings);
        Date endTime = new Date();
        long time = endTime.getTime() - startTime.getTime();
        Helper.printMessage("Время получения идентификаторов для " + elementsNumber + " строк: " + time);
        startTime= new Date();
        Set<String> stringSet = getStrings(shortener, keys);
        endTime = new Date();
        long time2 = endTime.getTime() - startTime.getTime();
        Helper.printMessage("Время получения строк для " + elementsNumber + " идентификаторов: " + time2);
        if (strings.equals(stringSet)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }

    }

    public static void main(String[] args) {
        long elementsNumber = 10000;
        testStrategy(new HashMapStorageStrategy(), elementsNumber);
    }
}

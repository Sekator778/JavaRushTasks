package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
       Map<String, Integer> casino = new HashMap<>();
        casino.put("Petrov", 5000);
        casino.put("Golovko", 1000);
        casino.put("Nazarov", 50);
        casino.put("nervnui", 400);
        casino.put("Petov", 150);
        casino.put("Golvko", 100);
        casino.put("Nazrov", 50);
        casino.put("nernui", 400);
        casino.put("Nazov", 5);
        casino.put("nenui", 40);
       return casino;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String , Integer> copyMap = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copyMap.entrySet())
        {
            if (pair.getValue()<500) map.remove(pair.getKey());
        }
    }
    public static void main(String[] args) {
//        Map<String, Integer> map = createMap();
//        Set set = map.entrySet();
//        for (Object o:set) {
//            System.out.println(o); }
//        removeItemFromMap(map);
//        System.out.println("-----after use this shit----------");
//        for (Object o:set) {
//            System.out.println(o); }
    }
}
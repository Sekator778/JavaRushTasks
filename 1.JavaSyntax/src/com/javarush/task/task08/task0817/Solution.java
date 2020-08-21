package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Nikolaichyk", "Petro");
        map.put("Borovuk", "Oleksandr");
        map.put("Zaborskui", "Petro");
        map.put("Prokopyuk", "Oleksandr");
        map.put("Dzydzin", "Anna");
        map.put("Petryk", "Grigorii");
        map.put("Goloborodko", "Oleksandr");
        map.put("Dyrko", "Ivan");
        map.put("Golohvastiv", "Oleksandr");
        map.put("Drygba", "Oleg");
        return map;//напишите тут ваш код
    }
    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Set <String> set = new HashSet<>(map.values());
        for (String name:set) {
            int count = 0;
            for (String nameOriginal:map.values()){
            if (name.equals(nameOriginal)) { count ++;
                }
            }
        if (count>1) {removeItemFromMapByValue(map, name);}
        }
    }
    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map = createMap();
        Set set = map.entrySet();
        for (Object o:set) {
            System.out.println(o); }
        removeTheFirstNameDuplicates(map);
        System.out.println("-------after --------");
        for (Object o:set) {
            System.out.println(o); }

    }
}

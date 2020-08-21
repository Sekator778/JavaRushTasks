package com.javarush.task.task08.task0805;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
На экране — значения!
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        printValues(map);
    }
    public static void printValues(Map<String, String> map) {
        ArrayList<String> values = new ArrayList<>(map.values());
        for(int i=0; i<values.size(); i++){
            System.out.println(values.get(i));
        }
    }
}


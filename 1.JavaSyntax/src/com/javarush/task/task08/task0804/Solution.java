package com.javarush.task.task08.task0804;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Вывести на экран список ключей
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
        printKeys(map);
    }
    public static void printKeys(Map<String, String> map) {
        List keylist = new ArrayList(map.keySet());
        for(int i=0; i<keylist.size(); i++){
            System.out.println(keylist.get(i));
        }
    }
}

package com.javarush.task.task08.task0815;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Nickolai", "Oleander");
        map.put("Nickolaichuk", "Mariia");
        map.put("Sobol", "Oleander");
        map.put("Hrysch", "Anatolii");
        map.put("Nickolaihol", "Oleander");
        map.put("Nickolaichukpollf", "Mariia");
        map.put("Sobolqwcc", "Oleander");
        map.put("Hryschscdcc", "Anatolii");
        map.put("Soblqwcc", "Oleander");
        map.put("Hryschscdc", "Anatolii");

        //напишите тут ваш код
    return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
       int x=0;
       for (Map.Entry<String, String> para : map.entrySet()){
           if (para.getValue().equals(name)) x++;
       }
       return x;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int max=0;
        for (Map.Entry<String,String> pair : map.entrySet()){
            if (pair.getKey().equals(lastName)) max++;
        }
        return max;
    }

    public static void main(String[] args) {
    //   System.out.println(createMap());
     //   System.out.println(getCountTheSameLastName(createMap(), "Sobol"));
    //   System.out.println("Skoko imen Oleander = " + getCountTheSameFirstName(createMap(), "Oleander"));
    }
}

package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class Solution {
    public static void main(String[] args) {
       Map<String, String> map = new HashMap<>();
        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");
    List  keylist = new ArrayList(map.keySet());
    for(int i=0; i<keylist.size(); i++){
        System.out.println(keylist.get(i) + " - " + map.get(keylist.get(i)));
    }
    }
}

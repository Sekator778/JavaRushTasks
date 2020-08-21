package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int id = 0;
        String name = null, s;
        while (true){
            s = reader.readLine();
            if (s.isEmpty()){
                break;}
            id = Integer.parseInt(s);
            name = reader.readLine();
            map.put(name, id);
        }                   //for (Map.Entry<String, Cat> pair : map.entrySet())
        for (Map.Entry<String, Integer> pair :map.entrySet()) {
            name = pair.getKey(); id = pair.getValue();
            System.out.println( id + "  " + name);
        }

    }
}

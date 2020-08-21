package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        while (true) {
            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }
            list.add(family);
        }
        // -----------
        String s1, s2;
        Map<String,String>map = new HashMap<>();
        for (int i = 0; i <list.size();) {
            s1 = list.get(i);
            s2 = list.get(i+1);
            map.put(s1, s2);
            i= i +2;

        }
        // Read the house number
        String city = reader.readLine();
//        int houseNumber = Integer.parseInt(reader.readLine());
        if (map.containsKey(city))
            System.out.println(map.get(city));
//        if (0 <= houseNumber && houseNumber < list.size()) {
//            String familyName = list.get(houseNumber);
//            System.out.println(familyName);
//        }
    }
}

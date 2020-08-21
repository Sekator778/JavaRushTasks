package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<>();
        ArrayList<String>list2 = new ArrayList<>();
        int min;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++){
            strings.add(reader.readLine());//напишите тут ваш код
        }
        min = strings.get(0).length();
        for (int j = 0; j<strings.size(); j++){
            if (min < strings.get(j).length())
                min = strings.get(j).length();
        }
        for (int j = 0; j < strings.size(); j++)  {
            if (min == strings.get(j).length()) {
                list2.add(strings.get(j));
            }
        }
        for (int j=0; j < list2.size(); j++)
            System.out.println(list2.get(j));

    }
}

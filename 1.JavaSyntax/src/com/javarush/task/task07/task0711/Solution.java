package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String>list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String s;
        for (int i = 0; i < 5; i++)
            list.add(reader.readLine());
        s = list.get(4);
        for (int i = 0; i < 13; i++){
            s = list.get(4);
            list.remove(4);
            list.add(0, s);//напишите тут ваш код
        }
        for (int j=0; j < list.size(); j++)
            System.out.println(list.get(j));
    }
}

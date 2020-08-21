package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>list = new ArrayList<String>();
      list.add("мама");
      list.add("именно");
      list.add("мыла");
      list.add("именно");
      list.add("раму");
      list.add("именно");
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println( list.get(i) );
            }//напишите тут ваш код
    }
}

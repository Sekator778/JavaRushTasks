package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/
public class Solution {
    public static void main(String[] args) throws Exception {
       ArrayList<String>list = new ArrayList<>();
       ArrayList<String>list2 = new ArrayList<>();
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int i = 0, min;
      String minS;
       while (i < 5){
           list.add(reader.readLine());
           i++;//напишите тут ваш код
       }
       min = list.get(0).length();
            for (int j = 0; j<list.size(); j++){
                if (min > list.get(j).length())
                    min = list.get(j).length();
            }
            for (int j = 0; j < list.size(); j++)  {
                if (min == list.get(j).length()) {
                 list2.add(list.get(j));
                          }
        }
        for (int j=0; j < list2.size(); j++)
          System.out.println(list2.get(j));

           }
}


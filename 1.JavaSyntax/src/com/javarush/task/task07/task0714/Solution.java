package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       ArrayList<String>list = new ArrayList<>();
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       for (int i = 0; i < 5; i++)
           list.add(reader.readLine());//напишите тут ваш код

       // System.out.println(list.size());
       list.remove(2);
       for(int i = 0; i<list.size(); i++){

           int j = list.size()-i-1;
           System.out.println(list.get(j));
       }
    }
}

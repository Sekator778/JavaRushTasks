package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       String[] st = new String[10];
       int []arr = new int[10];
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       for (int i=0; i<st.length; i++){
           st[i]= reader.readLine();//напишите тут ваш код
       }
       for (int i=0; i<st.length; i++){
           System.out.println(arr[i] = st[i].length());
       }
    }
}

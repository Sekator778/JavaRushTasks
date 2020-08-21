package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
     String name1 = read.readLine(); // считываем строку с клавиатур в строчную переменную name1
     int i = Integer.parseInt(name1); //преобразовываем строку в число.
     if (i>0)
     i = i*2;//напишите тут ваш код
        else if (i<0)
        i=i+1;
    System.out.println(i);
    }

}
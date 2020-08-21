package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
     String name1 = read.readLine();
     String name2 = read.readLine();
     String name3 = read.readLine();// считываем строку с клавиатур в строчную переменную name1
     int a = Integer.parseInt(name1), b = Integer.parseInt(name2), c = Integer.parseInt(name3);  //преобразовываем строку в число.
      int sum1,sum2,sum3;
      sum1=a+b;
      sum2=a+c;
      sum3=b+c;
      
      if (sum1>c && sum2>b && sum3>a)
            System.out.println("Треугольник существует.");
            else
            System.out.println("Треугольник не существует.");

     //напишите тут ваш код

    }
}
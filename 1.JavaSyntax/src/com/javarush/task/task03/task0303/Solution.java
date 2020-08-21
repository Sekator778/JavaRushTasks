package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
      double a, b;
       b = (convertEurToUsd (29, 1.2));
       a = (convertEurToUsd (25, 1.25));//напишите тут ваш код
       System.out.println (a);
       System.out.println (b);
    }

    public static double convertEurToUsd(int eur, double course) {
        double d = eur * course;
        
       return d;//напишите тут ваш код

    }
}

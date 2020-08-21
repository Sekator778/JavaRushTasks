package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
       double a = x2-x1;
       double b = y2-y1;
       double c = Math.sqrt(a*a+b*b);
       return c;//напишите тут ваш код

        // a=Math.sqrt((x2 - x1) * (x2 - x1)) + (y2 - y1) * (y2 - y1));
    }

    public static void main(String[] args) {
    //    System.out.println("c = "+ getDistance(1,1,2,4));
    }
}

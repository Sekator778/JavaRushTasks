package com.javarush.task.task02.task0217;

/* 
Минимум четырех чисел
*/
public class Solution {
    public static int min(int a, int b, int c, int d) {
       int m1, m2 = min (a, b), m3 = min (c, d);
       if (m2 < m3) m1 = m2;
       else         m1 = m3;
       return m1;//напишите тут ваш код

    }

    public static int min(int a, int b) {
       int m1;
       if (a < b) m1 = a;
       else       m1 = b;
       return m1;//напишите тут ваш код

    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}
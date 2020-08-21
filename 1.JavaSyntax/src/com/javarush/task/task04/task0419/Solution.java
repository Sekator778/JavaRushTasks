package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s1 = reader.readLine();
    int a = Integer.parseInt(s1);
    String s2 = reader.readLine();
    int b = Integer.parseInt(s2);
    String s3 = reader.readLine();
    int c = Integer.parseInt(s3);
    String s4 = reader.readLine();
    int d = Integer.parseInt(s4);
    if (a==b && a==c && a==d)
    System.out.println(a);
    else
        if (a>b && a>c && a>d)
        System.out.println(a);
        else
            if (b>c && b>d)
            System.out.println(b);
            else
            if (d>c)
               System.out.println(d);
               else
                    System.out.println(c);//напишите тут ваш код
    }
}

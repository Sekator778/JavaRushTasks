package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String st1 =  reader.readLine();
       String st2 =  reader.readLine();
       int a = Integer.parseInt(st1);
       int b = Integer.parseInt(st2);
       if (a == b)  
       System.out.println(a);
       else 
        if (a<b)
       System.out.println(a);
       else
       System.out.println(b);

    }
}
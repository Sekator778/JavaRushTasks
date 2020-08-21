package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int x=0;
        while (true) {
            String s = reader.readLine();
            int a = Integer.parseInt(s);
            if (a != -1) x=x+a;
            else  break;
        }
        System.out.println(x+(-1));

    }
}

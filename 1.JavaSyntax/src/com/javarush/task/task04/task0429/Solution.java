package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
int p=0, n=0;
if (a>0) p++;
if (b>0) p++;
if (c>0) p++;
if (a==0) n++;
if (b==0) n++;
if (c==0) n++;
n=3-p-n;
System.out.println("количество отрицательных чисел: "+ n);
System.out.println("количество положительных чисел: "+ p);
    }
}

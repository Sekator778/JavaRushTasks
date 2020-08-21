package com.javarush.task.task04.task0441;

/* 
Как-то средненько
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
        int x=0;
        if (a==b && a==c) x=a;
    else if (a==b) x=a;
    else if (b==c) x=b;
    else if (c==a) x=c;
        else if ((a<b && a>c) ||(a>b && a<c)) x=a;
        else if ((b<c && b>a) || (b>c && b<a)) x=b;
        else x=c;


        System.out.println(x);
    }
}

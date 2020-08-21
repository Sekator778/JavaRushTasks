package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        int k=0;
        double a;
        while (true) {
          //  System.out.println("tyt pered stringom");
           String s1 = reader.readLine();
            a = Double.parseDouble(s1);
          //  System.out.println(a);
            if (a != -1) {k++; sum=sum+a;}
            else break;
        }
            System.out.println(sum/k);
    }
}

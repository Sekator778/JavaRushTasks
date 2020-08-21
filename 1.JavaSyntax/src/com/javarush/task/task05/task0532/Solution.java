package com.javarush.task.task05.task0532;

import java.io.*;

/*
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int N = Integer.parseInt(reader.readLine());
        while (N>0) {
            int a = Integer.parseInt(reader.readLine());
            maximum = Math.max(maximum,a);
            N--;
        }
        System.out.println(maximum);
    }
}

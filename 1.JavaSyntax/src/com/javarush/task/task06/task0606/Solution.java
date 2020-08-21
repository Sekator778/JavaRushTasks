package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    n = Math.abs(n);
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            if (k%2==0) even++;
            else odd++;
        }
        System.out.println("Even: " + even + " Odd: "+ odd);
    }
}

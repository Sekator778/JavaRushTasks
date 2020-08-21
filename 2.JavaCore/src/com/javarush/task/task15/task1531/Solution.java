package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if (n > 0) {
            BigInteger fact = BigInteger.valueOf(1);
            for (int i = 1; i <= n; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            return String.valueOf(fact);
        } else if (n == 0) {
            return  "1";
        } else
            return  "0";
    }


}

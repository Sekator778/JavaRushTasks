package com.javarush.task.task34.task3402;

/* 
Факториал с помощью рекурсии
*/

import java.util.stream.LongStream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
        System.out.println("******** stream *******");
        System.out.println(solution.factorialUsingStreams(9));     //362880
        System.out.println(solution.factorialUsingStreams(0));     //1
        System.out.println(solution.factorialUsingStreams(1));     //1
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        return n * factorial(n - 1);
    }
    public int factorialUsingStreams(int n) {
        return (int) LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }
}


package com.javarush.task.task34.task3401;

/* 
Числа Фибоначчи с помощью рекурсии
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("******* Recursive Method ********");
        System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
        System.out.println("******* Iterative Method ********");
        System.out.println(solution.nthFibonacciTerm(9));     //34
        System.out.println(solution.nthFibonacciTerm(5));     //5
        System.out.println(solution.nthFibonacciTerm(2));     //1
        System.out.println(solution.nthFibonacciTerm(1));     //1
    }

    public int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public int nthFibonacciTerm(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int n0 = 0, n1 = 1;
        int tempNthTerm;
        for (int i = 2; i <= n; i++) {
            tempNthTerm = n0 + n1;
            n0 = n1;
            n1 = tempNthTerm;
        }
        return n1;
    }
}

package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {

    public void recurse(int n) {
        int m = 2;
        while (m <= n) {
            if ((n % m) == 0) {
                if (m != n) {
                    System.out.println(m + "");
                    recurse(n / m);
                } else {
                    System.out.println(m);
                }
                return;
            }
            m++;
        }
    }

    public static void main(String[] args) {
        new Solution().recurse(132);
    }
}

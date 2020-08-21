package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        int i = 0, x = 0;
        while (i < 10) {
            x = 0;
            while (x < 10) {
                System.out.print("S");
                x++;
            }
            System.out.println();
            i++;
        }
    }
}
package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int i=1,x=0;
        while (i < 11) {
            x = 1;
            while (x < 11) {
                System.out.print(" "+ i*x);
                x++;
            }
            System.out.println();
            i++;
        }
    }
}

package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int i = 1, h = 1, v = 1, j = 1, x = 0;
      while (j <= 10) { 
           i = h;
       while (i <= 10) {
        x = h * v;    
        System.out.print(x + " ");
             h = h + 1;
             i = i + 1;
       }//напишите тут ваш код
        v = v + 1;
        System.out.println (" ");
             h = 1;
             j = j + 1;        }   
    }
}

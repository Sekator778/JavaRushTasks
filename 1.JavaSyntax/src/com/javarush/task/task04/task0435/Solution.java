package com.javarush.task.task04.task0435;

/* 
Четные числа
*/

public class Solution {
    public static void main(String[] args) {
      int x=1;
       for (int i=0; i<=100; i++)
         {  if (x%2==0)
             System.out.println(x);
         x++;
         }
    }
}

package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s  = reader.readLine();
      int x = Integer.parseInt(s); // number
     int i = s.length();//  i = length number
 if (x>999 || x<1)        ;
 else
            if (x%2==0 && i==1)      System.out.println("четное однозначное число");
                else if (x%2==0 && i==2) System.out.println("четное двузначное число");
                     else if (x%2==0 && i==3) System.out.println("четное трехзначное число");
// no  chetnie
    else if (x%2!=0 && i==1) System.out.println("нечетное однозначное число");
        else if (x%2!=0 && i==2) System.out.println("нечетное двузначное число");
            else System.out.println("нечетное трехзначное число");
       // System.out.println("length = "+ i);


    }
}

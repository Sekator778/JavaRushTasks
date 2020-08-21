package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
   BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
     String name1 = read.readLine();
     String name2 = read.readLine();
     String name3 = read.readLine();// считываем строку с клавиатур в строчную переменную name1
     int a = Integer.parseInt(name1), b = Integer.parseInt(name2), c = Integer.parseInt(name3);  //преобразовываем строку в число.
      if (a==b && b==c)
      System.out.println(""+a+ " "+b+" "+c);
      else
          if (a==b)
           System.out.println(""+a+ " "+b);
        else
            if (a==c)
            System.out.println(""+a+ " "+c);
            else
                if (b==c)
                System.out.println(""+b+ " "+c);//напишите тут ваш код

    }
}
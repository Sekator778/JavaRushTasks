package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
     BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
     String name1 = read.readLine(); // считываем строку с клавиатур в строчную переменную name1
     double t = Double.parseDouble(name1);
    while (t>=5)
           t=t-5;
    if (0<=t && t<3.0)  
    System.out.println("зелёный");
    else if (3.0<=t && t<4.0)
    System.out.println("жёлтый");
    else
    System.out.println("красный");
       //напишите тут ваш код

    }
}
package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
     String nameYear = read.readLine(); // считываем строку с клавиатур в строчную переменную name1
     int i = Integer.parseInt(nameYear); //преобразовываем строку в число.  //напишите тут ваш код
int a = i % 400, x = 0; // 
if (i == 1700 && i == 1800 && i == 1900 && i == 2100 && i ==2200 && i == 2300){
x = 365;
System.out.println("количество дней в году: " + x);} // intercalary year
else if (i % 400 == 0){
    x = 366;
    System.out.println("количество дней в году: " + x);} // regular year
else if (i % 100 == 0){
    x = 365;
    System.out.println("количество дней в году: " + x);} // regular year
else if (i % 4 == 0){
    x = 366;
System.out.println("количество дней в году: " + x);} // intercalary year
else {
x = 365;
System.out.println("количество дней в году: " + x); }// regular year

    }
}
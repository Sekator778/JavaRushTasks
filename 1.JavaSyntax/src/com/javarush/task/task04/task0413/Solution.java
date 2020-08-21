package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
     String name1 = read.readLine(); // считываем строку с клавиатур в строчную переменную name1
     int i = Integer.parseInt(name1); //преобразовываем строку в число.
     if (i==1)
     System.out.println("понедельник");// =1 понедельник
    //напишите тут ваш код
        else if (i==2)
    System.out.println("вторник");
    if (i==3)
     System.out.println("среда");// =3  среда   
        else if (i==4)
    System.out.println("четверг");
    if (i==5)
     System.out.println("пятница");// =5  пятница    
        else if (i==6)
    System.out.println("суббота");
    if (i==7)
     System.out.println("воскресенье");// =7  воскресенье    
        else if (i>7 || i<1) 
    System.out.println("такого дня недели не существует");
    
    
        

    }
}
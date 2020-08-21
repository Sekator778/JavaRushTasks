package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     String s1 = reader.readLine();
     int a = Integer.parseInt(s1);
     String s2 = reader.readLine();
     int b = Integer.parseInt(s2);
     String s3 = reader.readLine();
     int c = Integer.parseInt(s3);//напишите тут ваш код
     int min1 = 0, min2 = 0, min3 = 0;
     // low
            if (a<b && a<c) min1 = a;
                else
                    if (b<c) min1 = b;
                    else min1=c;
                   
                                            // high
                                            if (a>b && a>c) min3 = a;
                                            else if (b>c) min3 = b;
                                                else min3 = c;
                                                
                                                 // midle
                      //  if ((a>b && a<c) || (a>c && a<b)) min2 = a;
                       // else
                     //   if (b>=c) min2 = c;
                        //    else min2 = b;
                        if ((min1 == a || min1 == b) && (min3 == a || min3 == b)) min2 = c;
                        else 
                                if ((min1 == c || min1 == b) && (min3 == c || min3 == b)) min2 = a;
                         else min2 = b;       
                                
    System.out.println(min3 + " "+ min2 + " "+ min1);
    }
}

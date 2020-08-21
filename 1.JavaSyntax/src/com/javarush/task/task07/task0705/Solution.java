package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int []bigArray = new int[20];
        int[]smArray1=new int[10];
        int[]smArray2=new int[10];
        for (int i=0; i<bigArray.length; i++){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            bigArray[i]=Integer.parseInt(reader.readLine());//напишите тут ваш код
                    }
        for (int i=0; i<bigArray.length; i++){
            if (i<10) smArray1[i]=bigArray[i];
            }
            for(int j=0; j<smArray2.length; j++)
            System.out.println(smArray2[j]=bigArray[j+10]);


        }
    }


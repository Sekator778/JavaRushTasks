package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        byte [] array = new byte[256];
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        while (fileInputStream.available() > 0) {
            array[fileInputStream.read()]++;
        }
        fileInputStream.close();
        byte max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) max = array[i];

        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) System.out.print(i +  " ");
        }


    }
}

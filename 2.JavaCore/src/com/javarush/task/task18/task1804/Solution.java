package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        byte[] array = new byte[256];
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        while (fileInputStream.available() > 0) {
            array[fileInputStream.read()]++;
        }
        fileInputStream.close();
        byte min = 1;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i] && array[i] > 0) min = array[i];
//            if (array[i] > 0) System.out.println(i + " " + array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) System.out.print(i + " ");
        }
    }
}

package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        byte min = Byte.MAX_VALUE, temp = 0;
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        while (fileInputStream.available() > 0) if (min > (temp = (byte)fileInputStream.read())) min = temp;
        fileInputStream.close();
        System.out.println(min);
    }
}

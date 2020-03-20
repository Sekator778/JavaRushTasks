package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int max = 0, temp = 0;
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        while (fileInputStream.available() > 0) if (max < (temp = fileInputStream.read())) max = temp;
        fileInputStream.close();
        System.out.println(max);
    }
}

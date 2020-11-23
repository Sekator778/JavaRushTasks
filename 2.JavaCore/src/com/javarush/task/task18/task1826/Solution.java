package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("text2.txt");
             FileOutputStream outputStream = new FileOutputStream("text3.txt")) {
            while (inputStream.available() > 0) {
                outputStream.write(inputStream.read() ^ 777);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

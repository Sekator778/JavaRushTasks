package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
//        String s = readUsingFiles(fileName);
//    String reverse = new StringBuffer(s).reverse().toString();
//        System.out.println(reverse);
//        reader.close();
//
//
//}
//    private static String readUsingFiles(String fileName) throws IOException {
//        return new String(Files.readAllBytes(Paths.get(fileName)));


        //-------------------------
        reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(new StringBuilder(line).reverse());
        }
        reader.close();
    }
}

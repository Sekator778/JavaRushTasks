package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Input name file");
        String name = reader.readLine();
        InputStream inStream = null;
        try{
         inStream = new FileInputStream(name);}
        catch (Exception e){
//            System.out.println("No file");
        }


        while (inStream.available() > 0)
        {
            int data = inStream.read(); //читаем один байт из потока для чтения
            char ch = (char) data;
            System.out.print(ch);
        }

        inStream.close(); //закрываем потоки
        reader.close();// напишите тут ваш код
    }
}
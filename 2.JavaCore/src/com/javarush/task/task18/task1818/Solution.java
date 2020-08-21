package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());


        FileInputStream fileInputStream = new FileInputStream(reader.readLine()); // read 2 file
        byte[] buff = new byte[fileInputStream.available()];
        fileInputStream.read(buff);
        fileInputStream.close();
        fileOutputStream.write(buff);      //write 2 file in 1 file


        String file3 = reader.readLine();
        //---------
        fileInputStream = new FileInputStream(file3);
        buff = new byte[fileInputStream.available()];
        fileInputStream.read(buff);
        fileOutputStream.write(buff);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
//FileOutputStream writer = new FileOutputStream(file1);
//FileInputStream reader = new FileInputStream(file2);
//
//byte[] buffer = new byte[reader.available()];
//reader.read(buffer); //Читаю сразу второй файл
//writer.write(buffer);
//reader.close();
//
//reader = new FileInputStream(file3);
//buffer = new byte[reader.available()];  //Переназначаю читать третий файл
//reader.read(buffer); //Читаю сразу третий файл
//writer.write(buffer);
//
//writer.close();
//reader.close();
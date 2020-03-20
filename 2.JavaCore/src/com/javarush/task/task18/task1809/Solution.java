package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        FileOutputStream fos = new FileOutputStream(reader.readLine());

        byte [] buff = new byte[fis.available()];
        fis.read(buff, 0, buff.length);

        for(int i = buff.length - 1; i >= 0; i--){
            fos.write(buff[i]);
        }
        fis.close();
        fos.close();
    }
}

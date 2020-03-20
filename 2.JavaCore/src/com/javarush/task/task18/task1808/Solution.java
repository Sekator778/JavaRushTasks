package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());

        //обработка данных
        int a = inputStream.available();
        byte[] buffer = new byte[(a + 1) / 2];
        int count = inputStream.read(buffer);

        //записи по файлам
        outputStream.write(buffer, 0, count);
        outputStream.close();
        outputStream = new FileOutputStream(reader.readLine());
        buffer = new byte[a / 2];
        count = inputStream.read(buffer);
        outputStream.write(buffer, 0, count);

        //конечное освобождение памяти
        inputStream.close();
        outputStream.close();
    }
}
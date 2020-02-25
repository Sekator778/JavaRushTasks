package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        byte [] buffer = new byte[inputStream.available()]; // размер пока доступен поток интовое там
        inputStream.read(buffer);                           // читаем в аррей байтовой боток
        // -------------
//        outputStream.write(new String(buffer, "UTF-8").getBytes("Windows-1251"));  // укороченый вариант новая строка с буфера в новой кодировке берет байт с аррей в старой кодировке
//
//        outputStream.write(new String(buffer, utf8).getBytes(windows1251));
        String s = new String(buffer, windows1251);         // все в строку указываем кодировку с буфера

        buffer = s.getBytes(utf8);                      // обратно в масив-аррей из строки в байти с новой кодировкой

        outputStream.write(buffer);                     // пишем в файл из буфера

        inputStream.close();
        outputStream.close();


    }
}

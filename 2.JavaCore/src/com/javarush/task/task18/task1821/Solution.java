package com.javarush.task.task18.task1821;

/*
Встречаемость символов
*/

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader.ready() читает инт чара - это и есть номер индекса а значение инкрементим каждый раз
 * вывод на экран кастуем (char) i == символ
 */
public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("#############  no file name in args  ###############");
            return;
        }
        int[] aSCII = new int[128];
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                aSCII[reader.read()]++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aSCII.length; i++) {
            if (aSCII[i] != 0) {
                System.out.println((char) i + " " + aSCII[i]);
            }
        }
    }
}

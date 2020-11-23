package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

/**
 * FileInputStream дает поток байт 0 - 256 == это индекс масива а значение кол-во встреч такого байта в файле
 * в мапу результат имяФайла это кей : а значение макс значение из всех количеств байт в файле
 */
public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        while (!((fileName = scanner.nextLine()).equalsIgnoreCase("exit"))) {
            System.out.println("you enter fileName: " + fileName);
            new ReadThread(fileName).start();
        }
        System.out.println("nameFile : maxCountByte");
        resultMap.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });

    }

    public static class ReadThread extends Thread {
        private final String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            byte[] bytes = new byte[256];
            try (FileInputStream inputStream = new FileInputStream(fileName)) {
                while (inputStream.available() > 0) {
                    int aByte = inputStream.read();
                    bytes[aByte]++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            int maxCount = 0;
            int maxCountByte = 0;
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] > maxCount) {
                    maxCount = bytes[i];
                    maxCountByte = i;
                }
            }
            resultMap.put(fileName, maxCountByte);
        }
    }
}

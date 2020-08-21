package com.javarush.task.task18.task1820;

/* 
Округление чисел
Простая задача - никаких боданий с валидатором.
1. Считал файл BufferedReader-ом в одну строку.
reader = new BufferedReader(new FileReader(fileName1));
String num = reader.readLine();

2. Разбил строку на массив строк методом split(" ")
String[] nums = num.split(" ");

3. Совместил парсинг, округление и запись одним циклом:
BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
for (int i = 0; i < nums.length; i++) {
        writer.write(Math.round(Double.parseDouble(nums[i]))+" ");
}

4. Закрыл потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader = new BufferedReader(new FileReader(fileName1));
        String num = reader.readLine();
        reader.close();
        String[] nums = num.split(" ");
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        for (int i = 0; i < nums.length; i++) {
            writer.write(Math.round(Double.parseDouble(nums[i]))+ " "); }
        writer.close();
    }
}

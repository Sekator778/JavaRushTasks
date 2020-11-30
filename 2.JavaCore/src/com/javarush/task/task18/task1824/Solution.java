package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.Scanner;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String fileName2 = scanner.nextLine();
            try (FileInputStream fileInputStream = new FileInputStream(fileName2)) {

            } catch (FileNotFoundException e) {
                System.out.println(fileName2);
                scanner.close();
                break;
            }
        }
    }
}
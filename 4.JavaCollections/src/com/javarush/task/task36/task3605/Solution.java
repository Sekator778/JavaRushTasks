package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        printToConsoleFiveFirstChar(readFileToTreeSet(args[0]));
    }

    public static TreeSet<Character> readFileToTreeSet(String fileName) {
        TreeSet<Character> result = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char ch : line.toLowerCase().toCharArray()) {
                    if (ch >= 97 && ch <= 122) {
                        result.add(ch);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void printToConsoleFiveFirstChar(TreeSet<Character> characters) {
        int count = 0;
        for (Character ch : characters) {
            System.out.print(ch);
            count++;
            if (count == 5) {
                break;
            }
        }
    }
}

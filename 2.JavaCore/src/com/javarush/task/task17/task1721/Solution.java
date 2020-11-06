package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> forRemoveLines = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("please input name file");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            allLines = Files.readAllLines(Paths.get(reader.readLine()), Charset.defaultCharset());
            forRemoveLines = Files.readAllLines(Paths.get(reader.readLine()), Charset.defaultCharset());
            new Solution().joinData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException("error");
        }
    }
}

package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] sArr = line.split(" ");
            map.merge(sArr[0], Double.parseDouble(sArr[1]), (oldName, oldDouble) -> oldName + Double.parseDouble(sArr[1]));
        }
        reader.close();
map.forEach((a, b) -> System.out.println(a + " " + b));
    }
}

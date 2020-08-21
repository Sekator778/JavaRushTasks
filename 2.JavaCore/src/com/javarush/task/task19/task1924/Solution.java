package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fileName));
        Pattern p = Pattern.compile("\\b\\d+\\b");  //все цифри отдельно стояшие и скоко хош их подряд
        Matcher m;
        String line;

        while ((line = reader.readLine()) != null) {
                if (line.equals(" ")) continue; // если есть пробел то делаем короче с каждим словом проверка
                m = p.matcher(line);     // или подходит оно под число
                while (m.find()){       // сюда попадаем если нашли число как отдельно стоящее слово целое
                    int digital = Integer.parseInt(m.group()); // делаем его интом сос троки
                    if (map.containsKey(digital)){ // ищем такое в мапе
                        line = line.replaceAll("\\b" + m.group() + "\\b", map.get(digital)); // заменяем его отдельно стоящее на вейлью с мапи по ключу
                    }
                }
            System.out.println(line);  // по одной линии и виводим
//                Thread.sleep(1000);
        }
        reader.close();

    }
}

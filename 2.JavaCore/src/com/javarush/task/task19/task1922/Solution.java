package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("А");
        words.add("Б");
        words.add("Д");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(nameFile));
        String line;
        Pattern p;
        Matcher m;
        int count;
        while ((line = reader.readLine()) != null) {
            count = 0;                  // счетчик в 0
            for (String word : words) {  // перебор по листу погнали
                p = Pattern.compile("\\b" + word + "\\b"); // сюда в патерн лепим сово из листа каждое
                m = p.matcher(line);
                if (m.find()) count++;                  // если есть такое то счетчик+
            }
                if (count == 2) System.out.println(line);  // сюда попадаем когда уже фор ич из листа весь прошел и тогда ифаем на 2 количество если ок то соут
            }
            reader.close();
    }
}
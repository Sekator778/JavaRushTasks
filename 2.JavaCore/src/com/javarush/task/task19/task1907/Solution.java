package com.javarush.task.task19.task1907;

/* 
Считаем словоСчитаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
//        FileReader fileReader = new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));// в буфер хаваем символ из файла
        Pattern pattern = Pattern.compile("(\\bworld\\b)"); // только отдельно стоящие слова world \b раница между символом и не символом
        int count = 0;
        while (bufferedReader.ready()){
            String s = bufferedReader.readLine();
            Matcher m = pattern.matcher(s);
            while (m.find()){count+= m.groupCount();}           // тут все вхождения по патерну
        }
//        fileReader.close();
        bufferedReader.close();
        System.out.println(count);
    }

}

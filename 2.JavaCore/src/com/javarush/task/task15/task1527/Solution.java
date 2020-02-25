package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/
//https://javarush.ru/tasks/com.javarush.task.task15.task1527#discussion

public class Solution {
    public static void main(String[] args) throws IOException {
        String URL = new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("^(.*?\\?)", ""); // 1. Создаем URL. Считываем. Обрезаем всё что до первого знака вопроса (включительно) [Повторные знаки ? уже войдут в остаток URL, засчёт связки с квантификатором *? ]
        for (String s : URL.split("&")) System.out.println(s.replaceAll("=.*$", "") + " ");//2. Сплитим строки по символу & и сразу по этим строкам пробегаемся через for-each. Внутри псевдо-обрезаем правую часть вместе с =  и выводим на экран содержимое через пробел.
        System.out.println();//3. Переходим на следующую строку.
        for (String s : URL.split("&")){//4. Опять сплитим строки по символу & и сразу по этим строкам пробегаемся через for-each.
            if (s.replaceAll("=.*$", "").equals("obj")){ //5. Внутри псевдо-обрезав правую часть вместе с = сравниваем, что это obj.
                try{
                    alert(Double.parseDouble(s=s.replaceAll("^[^=]*=", "")));
                } catch (NumberFormatException e){
                    alert(s);
                }
            }
        }
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

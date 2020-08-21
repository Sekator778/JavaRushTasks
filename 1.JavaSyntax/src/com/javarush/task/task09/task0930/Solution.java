package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (isNumber(array[i]) && isNumber(array[j])){
                    if (Integer.parseInt(array[i]) > Integer.parseInt(array[j])){
                        String temp = (array[i]);
                        (array[i]) = (array[j]);
                        (array[j]) = temp;
                    }
                }
                else if (!isNumber(array[i]) && !isNumber(array[j])){
                    if (isGreaterThan(array[j], array[i])){
                        String temp = (array[i]);
                        (array[i]) = (array[j]);
                        (array[j]) = temp;
                    }
                }
            }

        }
    }

    //Короткое решение, обычная сортировка с добавлением  if-ов.
    //Алгоритм такой:
    //1) берем первый элемент i массива в цикле
    //2) берем следующий элемент j массива во втором цикле
    //3) сравниваем его с предыдущим
    //- if (если i число и  j число)
    //----if (Integer.parseInt [ j ]  > Integer.parseInt [ i ])
    //-------то меняем их местами
    //- if (если i не число и j не число)
    //--- if( isGreaterThan(  i , j ) )
    //-------то меняем их местами
    //
    //как определить что строка (строка - это не число):
    //if ( !isNumber ( " привет " ) ) выдаст true
    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}

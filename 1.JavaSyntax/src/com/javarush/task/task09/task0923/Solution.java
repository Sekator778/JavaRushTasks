package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] sArray = s.toCharArray();
        String sOdd = "";
        String sEven = "";
        for(int i = 0; i < sArray.length; i++) {

            if (sArray[i] != ' '){
            if (isVowel(sArray[i])) {
                sEven = sEven + sArray[i] + " ";
                            }
            else {sOdd = sOdd + sArray[i] + " ";}}
        }

        System.out.println(sEven);
        System.out.println(sOdd);
        //напишите тут ваш код
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}
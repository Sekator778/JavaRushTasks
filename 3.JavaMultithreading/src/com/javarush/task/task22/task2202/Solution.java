package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string){
        if (string == null) throw new TooShortStringException();
        String result = null;
        int l = string.length();
        int count = 0;
            for (int i = 0; i < l; i++) {
                if (string.charAt(i) == ' ')count++;
            }
       if (count < 4) throw new TooShortStringException();
        String [] array = string.split(" ");
        result = String.format("%s %s %s %s", array[1], array[2], array[3], array[4]);


        return result;

    }

    public static class TooShortStringException extends RuntimeException{
    }
}

package com.javarush.task.task09.task0906;

/* 
Логирование стек-трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        String s1_class = Thread.currentThread().getStackTrace()[2].getClassName();
        String s2_met = Thread.currentThread().getStackTrace()[2].getMethodName();//напишите тут ваш код
        System.out.println(s1_class+": "+s2_met+": "+s);
    }
}

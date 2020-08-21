package com.javarush.task.task09.task0904;

/* 
Стек-трейс длиной 10 вызовов
*/

public class Solution {
    public static void main(String[] args) {
        int stackTraceLength = method1().length - method10().length + 1;
     //   System.out.println(stackTraceLength);
    }

    public static StackTraceElement[] method1() {
        return method2();
    }

    public static StackTraceElement[] method2() {
        return method3();//напишите тут ваш код
    }

    public static StackTraceElement[] method3() {
        return method4();//напишите тут ваш код
    }

    public static StackTraceElement[] method4() {
        return method5();//напишите тут ваш код
    }

    public static StackTraceElement[] method5() {
        return method6();//напишите тут ваш код
    }

    public static StackTraceElement[] method6() {
        return method7();//напишите тут ваш код
    }

    public static StackTraceElement[] method7() {
        return method8();//напишите тут ваш код
    }

    public static StackTraceElement[] method8() {
        return method9();//напишите тут ваш код
    }

    public static StackTraceElement[] method9() {
        return method10();
    }

    public static StackTraceElement[] method10() {
        return Thread.currentThread().getStackTrace();
    }
}

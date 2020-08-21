package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
       int pl = a+b;
        //напишите тут ваш код
        return pl;
    }

    public static int minus(int a, int b) {
        int min = a-b;
        return min;
    }

    public static int multiply(int a, int b) {
        int mult = a*b;
        return mult;
    }

    public static double division(int a, int b) {
        double div = (double) a / b;
        return div;
    }

    public static double percent(int a, int b) {
        double per = (double)b/100*a;
        return per;
    }

    public static void main(String[] args) {
  //      System.out.println("division - "+ division(10,3));
   //    System.out.println("percenr - " + percent(4,50));
    }
}
package com.javarush.task.task04.task0402;

/* 
Цена яблок
*/

public class Solution {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        apple1.addPrice(50);
        Apple apple2 = new Apple();
        apple2.addPrice(100);
        System.out.println("Стоимость яблок " + Apple.applesPrice);
    }

    public static class Apple {
        public static int applesPrice = 0;

        public static void addPrice(int applessum) {
           Apple.applesPrice = applessum + applesPrice; //напишите тут ваш код

        }
    }
}

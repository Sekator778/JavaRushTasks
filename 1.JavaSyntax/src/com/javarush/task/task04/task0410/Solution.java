package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
        checkInterval(10);
    }

    public static void checkInterval(int a) {
       if (a<100 && a>50)
        System.out.println("Число " + a + " содержится в интервале.");
        else
        System.out.println("Число " + a + " не содержится в интервале.");
    // тут ваш код

    }
}
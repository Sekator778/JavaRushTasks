package com.javarush.task.task07.task0723;

/* 
Обратный отсчёт
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
     //   ArrayList<Integer>list = new ArrayList<>();

        for (int i = 30; i >= 0; i--) {
            Thread.sleep(100);
            System.out.println(i);}

            //напишите тут ваш код


        System.out.println("Бум!");
    }
}

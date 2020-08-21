package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        sort(array);
        System.out.println(array[9]);
        System.out.println(array[10]);
    }
    public static void sort(int[] array) {
        int j, temp;
        for (int i = 1; i < array.length ; i++) {
            temp = array[i];
            for ( j = i - 1; j >=0 && array[j]>temp ; j--) {
                array[j+1] = array [j];}
            array[j+1] = temp;
            }
        }//напишите тут ваш код

}

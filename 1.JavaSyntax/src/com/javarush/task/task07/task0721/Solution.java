package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;
        int[] Array = new int[20];
        for (int i = 0; i<Array.length; i++){
            Array[i] = Integer.parseInt(reader.readLine());
        }
        minimum = Array[0];
        maximum = Array[0];
        for (int i = 1; i<Array.length; i++){
            if (minimum > Array[i]){
                minimum = Array[i];
            }
            if (maximum < Array[i]){
                maximum = Array[i];
            }

        }

        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}

package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Минимальное из N чисел
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
//        for (Integer i:integerList) {
//            System.out.println(i);
//        }
       System.out.println(getMinimum(integerList));
    }
    public static int getMinimum(List<Integer> array) {
        Collections.sort(array);
        int x = array.get(0);
       return (x);
    }

    public static List<Integer> getIntegerList() throws IOException {
        List <Integer> integerList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Создать и заполнить список тут
        int x = Integer.parseInt(reader.readLine());
        for (int i = 0; i < x; i++) {
            integerList.add(Integer.parseInt(reader.readLine()));
        }
        return integerList;
    }
}

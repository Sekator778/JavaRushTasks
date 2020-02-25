package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

        Integer [] array = {13, 8, 15, 5, 17, 14};
        sort(array);
//        System.out.println(Arrays.toString(array));
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double midle;
        if (array.length % 2 == 1){
            midle = array[array.length/2];
        }else midle = (double)(array[array.length/2] + array[array.length/2 - 1])/2;
        Comparator<Integer> comparator = (o1, o2) -> {
            double result = Math.abs(midle-o1) - Math.abs(midle-o2);
            if (result != 0){
                return (int)Math.round(result);
            }else {
                return o1 - o2;
            }
        };
        Arrays.sort(array, comparator);
        return array;
        //Arrays.sort(array, (a, b) -> Math.abs(median - a) - Math.abs(median - b));
    }
}

package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(20.23, "One");
        labels.put((double)12, "two");
        labels.put((double)121, "three");
        labels.put(123.236, "four");
        labels.put(1.111, "five");
    }

    public static void main(String[] args) {

        System.out.println(labels);
    }
}

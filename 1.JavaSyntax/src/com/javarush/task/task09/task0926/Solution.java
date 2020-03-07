package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        int[] arr1 = { 1, 2, 3, 5, -9 };
        int[] arr2 = { 99, 101 };
        int[] arr3 = { 569, 598, 3982, 15998 };
        int[] arr4 = { 777, 77777, -7, -777, -7777, -7, -707 };
        int[] arr5 = {  };
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);
return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}

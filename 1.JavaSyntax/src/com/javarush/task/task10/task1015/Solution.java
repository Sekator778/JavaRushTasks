package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.List;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        List<String> list1 = new ArrayList<>();//напишите тут ваш код
        list1.add("I wanna program like they do at Oracle");
        List<String> list2 = new ArrayList<>();//напишите тут ваш код
        list2.add("Let you through my hotspot");
        List<String> list3 = new ArrayList<>();//напишите тут ваш код
        list3.add("ILet you through my hotspot");
        List<String> list4 = new ArrayList<>();//напишите тут ваш код
        list4.add("I'm object oriented and I'm ready to browse");
        List<String> list5 = new ArrayList<>();//напишите тут ваш код
        list5.add("So come into my house and I'll let you click my mouse");
        ArrayList<String>[] arr = new ArrayList[5];
        arr[0] = new ArrayList<>(list1);
        arr[1] = new ArrayList<>(list2);
        arr[2] = new ArrayList<>(list3);
        arr[3] = new ArrayList<>(list4);
        arr[4] = new ArrayList<>(list5);

        return arr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
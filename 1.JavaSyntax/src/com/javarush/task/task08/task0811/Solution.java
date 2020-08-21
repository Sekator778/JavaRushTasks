package com.javarush.task.task08.task0811;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Квартет «Методы»
*/

public class Solution {
    public static List getListForGet() {
       ArrayList list = new ArrayList();
       for(int i=0; i<list.size(); i++){
           list.get(i);//напишите тут ваш код
       }
    return list;
    }

    public static List getListForSet() {
        ArrayList list = new ArrayList();
        for (int i=0; i<list.size(); i++){
            list.set(i, new Object());//напишите тут ваш код
        }
        return list;
    }

    public static List getListForAddOrInsert() {
        LinkedList list = new LinkedList();
        for (int i=0; i<list.size(); i++){
            list.add(i, new Object());//напишите тут ваш код
        }
        return list;
    }

    public static List getListForRemove() {
        LinkedList list = new LinkedList();
        for (int i=0; i<list.size(); i++){
            list.remove();//напишите тут ваш код
        }
        return list;
    }

    public static void main(String[] args) {

    }
}

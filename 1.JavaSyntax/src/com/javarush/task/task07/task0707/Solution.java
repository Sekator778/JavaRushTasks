package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
     ArrayList<String>list = new ArrayList<String>();
     list.add("pervoe");
     list.add("vtoroe");
     list.add("tretee");
     list.add("chetvertoe");
     list.add("pyatoeeeeeee");
     int n = list.size();
        System.out.println(n);//напишите тут ваш код
        for(int i = 0; i <list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

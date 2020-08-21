package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       ArrayList<Integer>list = new ArrayList<>();
        ArrayList<Integer>list2 = new ArrayList<>(); // 3
        ArrayList<Integer>list3 = new ArrayList<>(); // 2
        ArrayList<Integer>list4 = new ArrayList<>();  // all

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++){
            list.add(Integer.parseInt(reader.readLine()));}


         for (int i = 0; i < list.size(); i++)   {
             if (list.get(i)%3 == 0) {
                 list2.add(list.get(i));}
                 if (list.get(i) % 2 == 0) {
                     list3.add(list.get(i));
                 }
             if ((list.get(i)%3 != 0) && (list.get(i) % 2 != 0))
                 list4.add(list.get(i));
               }
     //   System.out.println(" ---vhodyaschie ---  ");
        printList(list);
      //  System.out.println(" ---te sho na 3---  ");
        printList(list2);
     //   System.out.println(" ---te sho na 2---  ");
         printList(list3);
     //   System.out.println(" ---ostalnie ----  ");
         printList(list4);//напишите тут ваш код
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++)
        System.out.println(list.get(i));//напишите тут ваш код
    }
}

package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
       Set<Integer> set =  new HashSet<>();
           set.add(50);
           set.add(6);
           set.add(7);
           set.add(8);
           set.add(9);
           set.add(501);
           set.add(60);
           set.add(70);
           set.add(80);
           set.add(90);
           set.add(150);
           set.add(16);
           set.add(17);
           set.add(18);
           set.add(-9);
           set.add(-501);
           set.add(-60);
           set.add(-70);
           set.add(-8);
           set.add(-5);
         return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer x = iterator.next();
            if (x>10){ iterator.remove();}
        }
         return set;// напишите тут ваш код
    }


    public static void main(String[] args) {
        // System.out.println(createSet());
       // System.out.println(removeAllNumbersGreaterThan10(createSet()));
    }
    }


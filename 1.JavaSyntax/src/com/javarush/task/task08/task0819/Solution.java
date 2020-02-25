package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/* 
Set из котов
*/

public class Solution {
    public static class Cat{
    }

    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Iterator iterator = cats.iterator();
//        int i=0;
      while (iterator.hasNext()){
////         i++;
//          System.out.println("i = " + i);
          iterator.next();
//          if (i>1){
          iterator.remove();
          break;
      }
       //    напишите тут ваш код. step 3 - пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set <Cat> cat = new HashSet<Cat>();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        cat.add(cat1);
        cat.add(cat2);
        cat.add(cat3);
        //напишите тут ваш код. step 2 - пункт 2
        return cat;
    }
    public static void printCats(Set<Cat> cats) {
        for (Object o: cats) {
            System.out.println(o);
        }
        // step 4 - пункт 4
    }
  //   step 1 - пункт 1
}

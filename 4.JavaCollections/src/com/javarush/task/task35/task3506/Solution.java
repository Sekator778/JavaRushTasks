package com.javarush.task.task35.task3506;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* 
Wildcards
*/

public class Solution {

    public static <H> void add(List<? super H> destinationList, List<? extends H> sourceList) {
        ListIterator<? super H> destListIterator = destinationList.listIterator();
        ListIterator<? extends H> srcListIterator = sourceList.listIterator();
        for (int i = 0; i < sourceList.size(); i++) {
            destListIterator.add(srcListIterator.next());
        }
    }


    public static void main(String[] args) {
        List<B> destination = new ArrayList<>();
        destination.add(new B());
        List<C> source = new ArrayList<>();
        source.add(new C());
        add(destination, source);
        System.out.println(destination);
        System.out.println(source);

//
//        List<C> des1 = new ArrayList<>();
//        des1.add(new C());
//
//        List<B> sour1 = new ArrayList<>();
//        sour1.add(new B());
//       // add(des1, sour1);                   A, B, some, C, D
////                                         <- super some -> extend
    }

    static class A {
    }

    static class B extends A {
    }

    static class C extends B {
    }
}
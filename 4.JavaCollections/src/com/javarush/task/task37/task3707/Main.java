package com.javarush.task.task37.task3707;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        AmigoSet<Integer> set = new AmigoSet<>();
        System.out.println(set.add(5));
        System.out.println(set.add(5));
        System.out.println(set);
        Collection<Integer> collection = new ArrayList<>(
                Arrays.asList(1, 2, 3)
        );
        AmigoSet<Integer> set1 = new AmigoSet<>(collection);
        System.out.println(set1.toString());
    }
}

package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно

ppc умные люди есть
https://javarush.ru/help/25219
учись !!!!!!!!!!!!1
*/
public class Solution {


    public static void main(String[] args) {


        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human("Анатолий Булкин", 90,123));
        humans.add(new Human("Анатолий Булкин", 90,124));
        humans.add(new Human("Анатолий Вассерман",  77,122));
        humans.add(new Human("Анатолий Вассерман",  76,122));
        humans.add(new Human("Бешкек Абдурасул", 6,120));
        humans.add(new Human("Анатолий Вассерман",  64,160));
        humans.add(new Human("Василий Теркин", 7,111));
        humans.add(new Human("Василий Теркин", 7,114));

       Comparator<Human> nameComparator = new Comparator<Human>() {
           @Override
           public int compare(Human o1, Human o2) {
               return o1.name.compareTo(o2.name);
           }

       };
       Comparator<Human> ageComparator = new Comparator<Human>() {
           @Override
           public int compare(Human o1, Human o2) {
               return o1.age-o2.age;
           }
       };

        Comparator<Human> IQComparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.IQ-o2.IQ;
            }
        };

        Collections.sort(humans,new CustomizedComparator(nameComparator,ageComparator,IQComparator));
        for (int i =0; i<humans.size();i++){
            System.out.println(humans.get(i).name+" "+humans.get(i).age+" "+humans.get(i).IQ);
        }


    }

    public static class Human{
    public String name;
    public int age;
    public int IQ;

        public Human(String name, int age, int IQ) {
            this.name = name;
            this.age = age;
            this.IQ = IQ;
        }


    }
    public static class CustomizedComparator<T> implements Comparator<T>{
        private   Comparator<T>[] comparators;

        public CustomizedComparator(Comparator... comparators) {
            this.comparators = comparators;
        }

//лямбда ------------------------
//        @Override
//        public int compare(T t, T t1) {
//            return Arrays.stream(comparators).reduce(Comparator::thenComparing).orElseThrow(IllegalStateException::new).compare(t, t1);
//        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator comparator : comparators) { //листаем масив компараторов
                result = comparator.compare(o1, o2);  // и тут их поочереди считаем в ресалт с помощью компаре стандартного
                if (result != 0) {
                    break;
                }
            }
            return result;
        }

    }
}

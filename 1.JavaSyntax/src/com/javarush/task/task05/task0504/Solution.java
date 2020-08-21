package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
     Cat cat1 = new Cat("Vaska", 5, 50, 500);   //напишите тут ваш код
   Cat cat2 = new Cat("Boba", 2, 20, 200); 
    Cat cat3 = new Cat("Murzik", 3, 30, 300);    
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}
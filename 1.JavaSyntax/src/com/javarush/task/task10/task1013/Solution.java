package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }
//    Human hun1= new Human("Vasya");

    public static class Human {
        private String name;
        private int age;
        private boolean sex;
        private boolean status;
        private int dick;
        private int weight;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, boolean sex, boolean status) {
            this.name = name;
            this.sex = sex;
            this.status = status;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, boolean status, int age) {
            this.name = name;
            this.sex = sex;
            this.status = status;
            this.age = age;
        }

        public Human(String name, int weight, boolean sex) {
            this.name = name;
            this.sex = sex;
            this.weight = weight;
        }

        public Human(String name, int dick, int weight) {
            this.name = name;
            this.weight = weight;
            this.dick = dick;
        }

        public Human(String name, int dick, int weight, int age, boolean sex, boolean status) {
            this.name = name;
            this.weight = weight;
            this.status = status;
            this.dick = dick;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int dick, int weight, boolean sex) {
            this.name = name;
            this.weight = weight;
            this.dick = dick;
            this.sex = sex;
        }
    }
}

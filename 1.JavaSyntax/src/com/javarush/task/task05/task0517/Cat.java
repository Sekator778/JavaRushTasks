package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name, address, color;
    int age, weight, x=0;

// 1 construktor name jnly

    public Cat(String name) {
        this.name = name;
        this.address = null;
        this.color = "brown";
        this.age = x;
        this.weight = x ;
    }
 // ---------------- 2 name weight age

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.address = null;
        this.color = "brown";
        this.age = age;
        this.weight = weight;
    }
 // ------------------ 3 name age

    public Cat(String name, int age) {
        this.name = name;
        this.address = null;
        this.color = "brown";
        this.age = age;
        this.weight = x;
    }
//------------------- 4 weight, color

    public Cat(int weight, String color) {
        this.name = null;
        this.address = null;
        this.color = color;
        this.age = x;
        this.weight = weight;
    }
// ------------------- 5 weight, color, address

    public Cat(String address, String color, int weight) {
        this.name = null;
        this.address = address;
        this.color = color;
        this.age = x;
        this.weight = weight;
    }

//напишите тут ваш код

    public static void main(String[] args) {

    }
}

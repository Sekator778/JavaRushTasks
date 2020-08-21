package com.javarush.task.task15.task1523;
/*
Перегрузка конструкторов
Требования:
1. В классе SubSolution должно содержаться 3 различных конструктора.
2. В классе Solution должно содержаться 4 различных конструктора.
3. В классе Solution должны быть объявлены конструкторы со всеми возможными модификаторами доступа.
4. В классе SubSolution должны быть объявлены конструкторы со всеми возможными модификаторами доступа кроме private.
5. Класс Solution должен быть родителем класса SubSolution.
*/


public class Solution {
    String name;
    int age, weight;
    boolean sex;
    public static void main(String[] args) {

    }
    private Solution() {}

     protected Solution(String name) {
        this.name = name;
    }

     Solution(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Solution(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}


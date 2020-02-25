package com.javarush.task.task23.task2305;

import java.util.ArrayList;

/*
Inner
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
1.создаем массив типа Solution.
2.инициализируем каждый элемент массива (new Solution).
3.инициализируем каждый элемент массива внутреннего класса (new InnerClass) через созданный экземпляры класса Solution.

Часть лекции относящийся к этой задаче:
"Нельзя создать объект Door внутри статического метода в классе Car: негде взять ссылку на объект типа Car, который неявно передается в конструктор типа Door."

*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];


    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
      Solution[] solutions = new Solution[2];
      solutions[0] = new Solution();
      solutions[0].innerClasses[0] = solutions[0].new InnerClass();
      solutions[0].innerClasses[1] = solutions[0].new InnerClass();

      solutions[1] = new Solution();
      solutions[1].innerClasses[0] = solutions[1].new InnerClass();
      solutions[1].innerClasses[1] = solutions[1].new InnerClass();

//      solutions[1].innerClasses[4] = solutions[1].new InnerClass();

        return solutions;
    }


    public static void main(String[] args) {

    }
}

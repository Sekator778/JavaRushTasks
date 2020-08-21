package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
       for(int i=0; i<10; i++){
           Cat cat = new Cat();// Создай 10 котов
       }
        System.out.println(Cat.catCount);
        // Выведи значение переменной catCount
    }

    public static class Cat {
        public static int catCount = 0;
        public Cat(){
            catCount++;
        }
        // Создай статическую переменную catCount

        // Создай конструктор
    }
}

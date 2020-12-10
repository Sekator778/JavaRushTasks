package com.javarush.task.task37.task3702;

public interface AbstractFactory {
     default Human getPerson(int age) {
         return null;
    }
}
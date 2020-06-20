package com.javarush.task.task33.task3301;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * 1) В программе не выполнено основное требование к сериализации в JSON.
 * Найди ошибку и исправь.
 * 2) Расставь правильно JSON аннотации у классов.
 * Все данные должны сериализоваться.
 * <p>
 * <p>
 * Требования:
 * 1. Класс Pet должен быть помечен как готовый к сериализации в JSON.
 * 2. Класс Cat должен быть помечен как готовый к сериализации в JSON.
 * 3. Класс Dog должен быть помечен как готовый к сериализации в JSON.
 * 4. Все данные у классов Pet, Cat, Dog должны сериализоваться.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);

        StringWriter writer = new StringWriter();
        convertToJSON(writer, pets);
        System.out.println(writer.toString());
        //[{"name":"Murka","age":5,"weight":3},{"name":"Killer","age":8,"owner":"Bill Jeferson"}]
    }

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
    }

    @JsonAutoDetect
    public static class Pet {
        public String name;

        public Pet() {
        }
    }

    @JsonAutoDetect
    public static class Cat extends Pet {
        public int age;
        public int weight;

        public Cat() {
        }
    }

    @JsonAutoDetect
    public static class Dog extends Pet {
        public int age;
        public String owner;

        public Dog() {
        }
    }
}

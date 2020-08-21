package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
   Man man1 = new Man("Tolik", 32, "Kiev");
        System.out.println(man1.name + " "+ man1.age + " " + man1.address);
    Man man2 = new Man ("Sasha", 41, "Sydnei");
        System.out.println(man2.name + " "+ man2.age + " " + man2.address);

        Woman woman1 = new Woman("Zara", 21, "Boston");
        System.out.println(woman1.name + " "+ woman1.age + " " + woman1.address);
        Woman woman2 = new Woman ("Lola", 28, "Kiev");
        System.out.println(woman2.name + " "+ woman2.age + " " + woman2.address);


        //напишите тут ваш код
    }
    public static class Man {
        private String name, address;
        private int age;

        public Man(String name) {
            this.name = name;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.address = address;
            this.age = age;
                 }

        public Man(int age, String name) {
            this.name = name;
            this.address = null;
            this.age = age;
        }
    }
//--------------- woman-------------
public static class Woman {
    private String name, address;
    private int age;

    public Woman(String name) {
        this.name = name;
    }

    public Woman(String name, int age, String address) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Woman(int age, String name) {
        this.name = name;
        this.address = null;
        this.age = age;
    }
}
// напишите тут ваш код

}

package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human h1 = new Human("Dasha", true, 29);
        Human h2 = new Human("Petro", false, 79);
        Human h3 = new Human("Vasko", true, 61);
        Human h4 = new Human("Mila", false, 23);

        Human hH1 = new Human("Marina", false, 18, h3, h4);
        Human hH2 = new Human("Rembo", true, 18, h2, h1);
        Human hH3 = new Human("Dasha", false, 18, hH2, hH1);
        Human hH4 = new Human("Georgii", true, 18, hH2, h1);
        Human hH5 = new Human("Java", false, 18, h1, h4);
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        System.out.println(h4.toString());
        System.out.println(hH1.toString());
        System.out.println(hH2.toString());
        System.out.println(hH3.toString());
        System.out.println(hH4.toString());
        System.out.println(hH5.toString());
        // напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;// напишите тут ваш код
        Human (String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        Human (String name, boolean sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
        }
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}
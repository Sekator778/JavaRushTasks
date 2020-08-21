package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human children1 = new Human("Vasya _ Ребенок", true, 8);
        Human children2 = new Human("Marta _ Ребенок", false, 4);
        Human children3 = new Human("Dola _ Ребенок", false, 11);
        // ----------------- father mother
        Human hum1 = new Human("Bobo _Мама", false, 32, children1, children2, children3);
        Human hum2 = new Human("Huan _ Папа", true, 36, children1, children2, children3);
        // ------------ grand ----------
        Human grandHum1_1 = new Human("Lolo _ баба Мами", false, 76, hum1);
        Human grandHum1_2 = new Human("Solo _ дед Мами", true, 89, hum1);
        Human grandHum2_1 = new Human("Petro _ дед Папи", true, 96, hum2);
        Human grandHum2_2 = new Human("Mariia _ дед Папи", false, 114, hum2);

        ArrayList<Human> children = new ArrayList<Human>(Arrays.asList(children1, children2, children3, hum1, hum2, grandHum1_1, grandHum1_2, grandHum2_1, grandHum2_2));
        for (Human p:children) {
            System.out.println(p);
        }
    }


    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList <Human> children = new ArrayList<>();

       Human(String name, boolean sex, int age, Human ... children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.addAll(Arrays.asList(children));
       }
        Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
                   }


        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}

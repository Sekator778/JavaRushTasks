package com.javarush.task.task05.task0516;

/* 
Друзей не купишь
*/

public class Friend {
    private String name = null;
    private int age;
    private char sex;
    // ============1====
    public Friend(String name){
    this.name = name;
    }
    // ============2====
    public Friend(String name, int age){
        this.name = name;
        this.age =  age;
    }
    // ============3====
    public Friend(String name, int age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
   //напишите тут ваш код

    public static void main(String[] args) {
Friend fr1 = new Friend("momo");
Friend fr2 = new Friend("Basya", 12);

Friend fr3 = new Friend("lola", 12, 'f');
System.out.println(fr3.sex);


    }
}

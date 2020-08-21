package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
  private String name, address, color; // 5 haracteristik
  private int age, weight;
// ---- initialize -----#1 only name
public void initialize(String name){
    this.name = name;
    this.weight=7;
    this.color="red";
    this.age=7;
    this.address = null;
}// ----- initialize --name weight age -#2
public void initialize(String name, int weight, int age){
    this.name=name;
    this.weight=weight;
    this.age=age;
    this.color="red";
    this.address = null;
}// weight = standart - name age  #3
public void initialize(String name, int age){
    this.name=name;
    this.weight=7;
    this.age = age;
    this.color="red";
    this.address = null;
} // only weight and color  #4
public void initialize(int weight, String color) {
    this.weight=weight;
    this.color=color;
    this.name=null;
    this.address=null;
    this.age=7;
} 
// only weight color address #5
public void initialize(int weight, String color, String address) {
    this.weight=weight;
    this.color=color;
    this.name=null;
    this.address=address;
    this.age=7;
}

  //напишите тут ваш код


    public static void main(String[] args) {
//Cat cat1 = new Cat();
//cat1.initialize("Vaska");
//System.out.println(cat1.age);
    }
}

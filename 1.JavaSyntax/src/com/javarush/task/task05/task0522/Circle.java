package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;
    // cost po ymolch
public Circle(){
    this.radius=1000;  }  
  // --4 ----------    
public Circle(double x, double y, double radius){
    this.x=x;
    this.y=y;
    this.radius=radius;
}    
//   ------------1------
public Circle(double y, double x){
    this.x=x;
    this.y=y;
    this.radius=100;
}
// ----------- 2----------
public Circle(double x){
    this.x=x=y;
    this.radius=100;
}    
// ----------3 ------------
public Circle(Circle circle){
    this.x=circle.x;
    this.y=circle.y;
    this.radius=circle.radius;
}
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
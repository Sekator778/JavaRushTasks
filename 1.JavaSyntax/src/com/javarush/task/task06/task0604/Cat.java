package com.javarush.task.task06.task0604;

/* 
Ставим котов на счётчик
*/

public class Cat {
    public static int catCount = 0;
// -----------------
public Cat(){
    catCount++;}
// finalize
protected void finalize() throws Throwable{
    catCount--;
}
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
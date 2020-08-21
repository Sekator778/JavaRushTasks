package com.javarush.task.task06.task0602;

/* 
Пустые кошки, пустые псы
*/

public class Cat {
    public static void main(String[] args) {

    }
protected void finalize () throws Throwable{
    System.out.println("A Cat was destroyed");
}
 public Cat (){

 }   //напишите тут ваш код

}

class Dog {
   protected  void finalize() throws Throwable{
       System.out.println("A Dog was destroyed");
   }
   public Dog(){

   }//напишите тут ваш код
}

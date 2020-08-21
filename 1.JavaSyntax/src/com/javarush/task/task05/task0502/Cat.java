package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        
        int a=0;
        int b=0;
        
        if (this.age > anotherCat.age) a++;
        else if (anotherCat.age > this.age) b++;
     //   System.out.println(" v sereduni"+ a+ " "+b);
            if (this.weight>anotherCat.weight) a++;
            else if (this.weight<anotherCat.weight) b++;
            
            if (this.strength>anotherCat.strength) a++;
            else if (this.strength<anotherCat.strength) b++;
      //      System.out.println("pered if a= "+ a + " b =  "+b);
        if (a>b) return true;
        else return false;
   
        //напишите тут ваш код
    }

    public static void main(String[] args) {
/*Cat cat1 = new Cat ();
Cat cat2 = new Cat();
cat1.age = 1;
cat2.age=4;
cat1.strength=3;
cat2.strength=3;
cat1.weight=1;
cat2.weight=1;
if ((cat1.fight(cat2))==true)
System.out.println ("win 1 cat tyt true");
else
System.out.println("win 2 cat"); */
    }
}

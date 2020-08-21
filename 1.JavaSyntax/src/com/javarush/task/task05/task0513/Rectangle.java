package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
   private int top, left, width, height;
    // ---- 1 void
   public void initialize (int top, int left, int width, int height){
       this.top = top;
       this.left=left;
       this.width=width;
       this.height=height;
       
   }
  // ---- 2 void
    public void initialize(int top, int left){
        this.top = top;
       this.left=left;
       this.width=5;
       this.height=500; 
    } 
     // --- 3 void
    public void initialize(int top){
        this.top=top;
        this.left=100;
        this.width=width=height;
    }
   
     // ----- 4 void
   public void initialize (Rectangle rectangle){
       this.top = rectangle.top;
       this.left=rectangle.left;
       this.width=rectangle.width;
       this.height=rectangle.height;
   }
   
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}

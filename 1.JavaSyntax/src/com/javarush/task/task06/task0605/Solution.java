package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.calculateMassIndex(weight, height);
    }

    public static class Body {
        public static void calculateMassIndex(double weight, double height) {
          double m = weight/(height*height);
          if (m<18.5) System.out.println("Недовес: меньше чем 18.5");
          else if (m>=18.5 && m<25) System.out.println("Нормальный: между 18.5 и 25");
          else if (m>=25 && m<30) System.out.println("Избыточный вес: между 25 и 30");
          else  if (m>=30) System.out.println("Ожирение: 30 или больше");
         //   System.out.println("inlex = "+ m);// напишите тут ваш код
        }
    }
}

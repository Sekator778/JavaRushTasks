package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dedName = reader.readLine();
        Cat catDed = new Cat(dedName);
        String babaName = reader.readLine();
        Cat catBaba = new Cat(babaName);

        String papaName = reader.readLine();
      Cat catPapa = new Cat(papaName, null, catDed);
      String mamaName = reader.readLine();
      Cat catMama = new Cat(mamaName, catBaba, null);

        String sonName = reader.readLine();
        Cat son = new Cat(sonName, catMama, catPapa);
        String dochName = reader.readLine();
        Cat doch = new Cat(dochName, catMama, catPapa);

        System.out.println(catDed);
        System.out.println(catBaba);

        System.out.println(catPapa);
        System.out.println(catMama);

        System.out.println(son);
        System.out.println(doch);
    }

    public static class Cat {
        private String name;
        private Cat parent;
        private Cat parent2;

        Cat(String name) {

            this.name = name;
        }

        Cat(String name, Cat parent, Cat parent2) {
            this.name = name;
            this.parent = parent;
            this.parent2 = parent2;
        }

        @Override
        public String toString() {
            if (parent == null && parent2 == null)
                return "The cat's name is " + name + ", no mother, no father";
            else
                if  (parent == null)
                return "The cat's name is " + name + ", no mother, father is "+ parent2.name;
             else
                 if (parent2 == null)
                 return "The cat's name is " + name + ", mother is "+ parent.name + ", no father";
              else
                  return  "The cat's name is " + name + ", mother is "+ parent.name + ", father is "+ parent2.name;

        }
    }

}

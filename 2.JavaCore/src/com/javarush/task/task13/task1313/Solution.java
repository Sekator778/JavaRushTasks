package com.javarush.task.task13.task1313;

import java.awt.*;

/* 
Лисица — это такое животное
*/

public class Solution {
    public static void main(String[] args) throws Exception {
//        Fox lisa = new Fox();
//        System.out.println(lisa.getColor());
    }

    public interface Animal {
        Color getColor(); 
    }

    public static abstract class Fox implements Animal{
        public String getName() {
            return "Fox";
        }
    }
}
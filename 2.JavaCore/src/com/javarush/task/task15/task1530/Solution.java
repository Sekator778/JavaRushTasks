package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        TeaMaker tea = new TeaMaker();
        tea.makeDrink();
        LatteMaker latte = new LatteMaker();
        latte.makeDrink();
    }
}

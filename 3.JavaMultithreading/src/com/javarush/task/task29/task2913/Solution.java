package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        storName();
//        if (a > b) {
//            return a + " " + getAllNumbersBetween(a - 1, b);
//        } else {
//            if (a == b) {
//                return Integer.toString(a);
//            }
//            return a + " " + getAllNumbersBetween(a + 1, b);
//        }
        StringBuilder sb = new StringBuilder();
//`        if (a < b) {
//           for (int i = a; i <= b; i++){
//                sb.append(i);
//                sb.append(" ");
//            }
//        }else {
//            for (int i = a; i >= b; i--) {
//                sb.append(i);
//                sb.append(" ");
//            }
//        }`
        if (a > b) {
            do {
                sb.append(b);
                sb.append(" ");
                b++;
            } while (a >= b);
        } else do {
            sb.append(b);
            sb.append(" ");
            b++;
        } while (b >= a);

        return sb.toString().trim();
    }

    private static void storName() {
        String[] strings = new String[10];
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(10);
        numberB = random.nextInt(10);
        System.out.println("numA: " + numberA);
        System.out.println("numB: " + numberB);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));


    }
}
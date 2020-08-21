package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consolestream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newOutStream = new PrintStream(byteArrayOutputStream);
        System.setOut(newOutStream);
        testString.printSomething();
        String [] strings = byteArrayOutputStream.toString().split("\\n"); // тут с масива в масив через приведение к строке и ету строку режем по пробелам
        System.setOut(consolestream);
        int count = 0;
        for (String s:strings) {
            System.out.println(s);
            count++;
            if (count % 2 == 0) System.out.println("JavaRush - курсы Java онлайн");
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

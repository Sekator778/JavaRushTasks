package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething(); // запихнули в масив outputStream когда в методе принтали то полетело в масив так как переопределили куда

        String s = outputStream.toString();
        System.setOut(consoleStream);           // назад поставили ранее сохранненіе настройки

        System.out.println(s.replaceAll("\\D+","")); // only digital



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}

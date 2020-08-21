package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething(); // запихнули в масив outputStream когда в методе принтали то полетело в масив так как переопределили куда

        String s = outputStream.toString();
        String result = null;
        System.setOut(consoleStream);

        Matcher m = Pattern.compile("(\\d+) ([\\+\\-\\*]) (\\d+)").matcher( s );  // тут ловим 3 групи 1я цифра любая вторая + - * третья цифра любая и количество цифр любое

        if (m.find()) {         // тут если нашли по патерну в строке s
            if ("+".equals(m.group(2))) result = String.format("%s + %s = %d", m.group(1), m.group(3), Integer.parseInt(m.group(1)) + Integer.parseInt(m.group(3))); // тут equals  чтото к 2й групе

            // складываем m.group(1) и m.group(3)
     else if ("-".equals(m.group(2))) result = String.format("%s - %s = %d", m.group(1), m.group(3), Integer.parseInt(m.group(1)) - Integer.parseInt(m.group(3)));
            // вычитаем из m.group(1) m.group(3)
     else result = String.format("%s * %s = %d", m.group(1), m.group(3), Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(3)));
            // умножаем m.group(1) и m.group(3)

        }
        System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


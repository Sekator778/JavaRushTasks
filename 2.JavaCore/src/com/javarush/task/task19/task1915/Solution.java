package com.javarush.task.task19.task1915;

/* 
Дублируем текст
Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку "it's a text for testing".
5. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
6. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
7. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c конструктором принимающим ByteArrayOutputStream).
8. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
9. Метод main(String[] args) класса Solution должен один раз вызвать метод printSomething() объекта testString.
10. Метод main(String[] args) класса Solution должен выводить и в консоль и в файл строку выведенную методом printSomething() (используй FileOutputStream).
11. Поток записи в файл (FileOutputStream) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();

        String s = outputStream.toString();
        System.setOut(consoleStream);
        //---
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        FileOutputStream fileOutputStream = new FileOutputStream(nameFile);

        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();
        System.out.println(s);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}


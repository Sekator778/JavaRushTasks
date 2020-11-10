package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/**
 * Реализуй логику метода String decode(StringReader reader, int key).
 * Метод получает данные в закодированном виде.
 * Он должен вернуть дешифрованную строку, что хранится в StringReader - е.
 * Возвращаемый объект ни при каких условиях не должен быть null.
 * Метод main не участвует в тестировании.
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать метод String decode(StringReader reader, int key).
 * 2. Метод decode(StringReader reader, int key) должен вернуть дешифрованную строку что хранится в StringReader - е.
 * 3. Возвращаемый объект ни при каких условиях не должен быть null.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuffer sb = new StringBuffer();
        int x;
        try {

            while ((x = reader.read()) != -1) {
                sb.append((char) (x + key));
            }
        } catch (Exception e) {
            return new String();
        }
        return sb.toString();
    }
}

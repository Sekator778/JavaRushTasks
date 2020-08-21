package com.javarush.task.task19.task1904;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать данные только одного человека, в виде объекта класса Person.
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String line =  fileScanner.nextLine(); //прочел запись в файле
            String[]arr =  line.split(" ",4);//Разбил на 4 строки, последняя с датой
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd M y", Locale.ENGLISH);
                    Date date = dateFormat.parse(arr[3]);
            return new Person(arr[1],arr[2],arr[0],date);


        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}

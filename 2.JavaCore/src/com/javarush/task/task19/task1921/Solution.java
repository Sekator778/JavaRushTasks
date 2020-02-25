package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String line = reader.readLine();
            String stringName = line.replaceAll("[\\d]", "").trim();//все цифри в строке на пустоту и тримаем все пустое
            String[] digital = line.substring(stringName.length()).trim().split(" ");//в масив кусок от всей строки за вычетом предыдущей длины stringName и заспличеной по пробелам

            int day = Integer.parseInt(digital[0]);  // с масива по частям делать будем дату
            int month = Integer.parseInt(digital[1]);
            int year = Integer.parseInt(digital[2]);

            Date date = new GregorianCalendar(year, month-1, day).getTime(); // дату делаем
            PEOPLE.add(new Person(stringName, date));
        }
        reader.close();
        PEOPLE.forEach(System.out::println);
    }
}

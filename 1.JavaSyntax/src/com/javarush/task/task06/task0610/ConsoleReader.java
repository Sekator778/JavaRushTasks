package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String s = reader.readLine();
       return s;
    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int i = Integer.parseInt(reader.readLine());
    return i;
    }

    public static double readDouble() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   //напишите тут ваш код
    double d = Double.parseDouble(reader.readLine());
    return d;
    }

    public static boolean readBoolean() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));    //напишите тут ваш код
    boolean b = Boolean.parseBoolean(reader.readLine());
    return b;
    }

    public static void main(String[] args) throws Exception {
     //   System.out.println(readString());

    }
}

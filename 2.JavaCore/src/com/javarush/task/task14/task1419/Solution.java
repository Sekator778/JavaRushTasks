package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {

        int[] arr = new int[5];
        Object szStr[] = new String[10];
        Object ch = new Character('*');
                        //the first exception

        try {float i = 1 / 0;}
            catch (Exception e) { exceptions.add(e); }

        try {arr[5] = 2; }
             catch (Exception e) { exceptions.add(e);}

        try { File file = new File("path"); FileInputStream fis = new FileInputStream(file); }
              catch (Exception e) {exceptions.add(e); }

        try {arr[1] = Integer.parseInt("String");}
             catch (Exception e) {exceptions.add(e); }

        try {szStr[0] =  new Character('*');}  //5
              catch (Exception e) {exceptions.add(e); }
        try {System.out.println((Byte)ch);}  //6
             catch (Exception e) {exceptions.add(e); }
        try {int[] arrNeg = new int [-10];}
            catch (Exception e) {exceptions.add(e); }
        try {int[] arrNull = new int[5]; arrNull = null; int a= arrNull.length;}
        catch (Exception e) {exceptions.add(e); }
        try {String s = "123"; char ch1 = s.charAt(5);}
        catch (Exception e) {exceptions.add(e); }
       

        Object e = null;
        exceptions.add(new ExportException(new String("e")));


        //напишите тут ваш код

    }
    static class MyException extends Exception
    {
        // перевизначена функція getLocalizedMessage()
        public String getLocalizedMessage()
        {
            return "MyException.getLocalizedMessage()";
        }
    }
}

package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Работа с датой
*/
public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 8 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        Date date1 = new Date(Date.parse(date));
        SimpleDateFormat day = new SimpleDateFormat("D");
        int n = Integer.parseInt(day.format(date1));
    //    System.out.println(n);
        if (n % 2 == 0){
            return false;
        }
        else {
            return true;
        }
    }
}
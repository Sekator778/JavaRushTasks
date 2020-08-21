package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String>list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());
        //напишите тут ваш код //напишите тут ваш код
        int min = list.get(0).length();
        int max = list.get(0).length();
        int p1 = 0;
        int p2 = 0;
        for (int i=0; i<list.size(); i++){
            if (min> list.get(i).length()){
                min=list.get(i).length();
                p1 = i;}
            if (max<list.get(i).length()){
                max=list.get(i).length();
                p2 = i;}
            }
        if (p2 > p1) {
            System.out.println(list.get(p1));
        }
        else System.out.println(list.get(p2));
        }
    }

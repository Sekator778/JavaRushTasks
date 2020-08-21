package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Омовение Рамы
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String string1 = "";
        char ch, ch1;
        for (int i = 0; i <string.length() ; i++) {
            if ((string.charAt(i) == ' ')&&(string.charAt(i+1)!= ' ')){
                string1 = string1+' ';
            }
            else if ((string.charAt(i) != ' ')&&(i == 0)) {
                ch = Character.toUpperCase(string.charAt(i)); string1 = string1+ch;
            }
            else if ((string.charAt(i) != ' ')&&(string.charAt(i-1) == ' ')){
                ch = Character.toUpperCase(string.charAt(i)); string1 = string1+ch;
            }
            else {
                ch = (string.charAt(i)); string1 = string1+ch;
            }

        }
        System.out.println(string1);
    }
}

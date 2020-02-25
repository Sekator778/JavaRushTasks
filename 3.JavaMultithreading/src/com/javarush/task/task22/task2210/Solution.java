package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String [] out = getTokens("level22.lesson13.task01", ".");
            for (String s : out) System.out.print(s);


    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);

        String [] result = new String[tokenizer.countTokens()];

        for (int i = 0; i < result.length; i++) {
            result[i] = tokenizer.nextToken();
        }

        return result;
    }
}

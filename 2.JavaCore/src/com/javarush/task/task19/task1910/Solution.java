package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String filein = reader.readLine();
        String fileOut = reader.readLine();
        reader.close();
        BufferedReader filereader = new BufferedReader(new FileReader(filein));
        BufferedWriter filewriter = new BufferedWriter(new FileWriter(fileOut));

        filewriter.write(filereader.readLine().replaceAll(("\\p{Punct}"),"")); //заменяет все знаки  пунктуации на ничего то есть удаляет

        filereader.close();
        filewriter.close();
    }
}
package com.javarush.task.task19.task1909;

/* 
Замена знаков
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

        filewriter.write(filereader.readLine().replaceAll("\\.", "!")); //заменяет все точки на !

        filereader.close();
        filewriter.close();
    }
}
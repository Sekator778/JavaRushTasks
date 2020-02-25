package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
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

        Pattern p = Pattern.compile("\\b[0-9]+\\b");
        while (filereader.ready()) {
            String s = filereader.readLine();
            Matcher m = p.matcher(s);
            while (m.find()) {
                filewriter.write(m.group() + " ");
            }
        }
        filereader.close();
        filewriter.close();
    }
}

package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String line;
        Pattern p = Pattern.compile("\\b[\\S]*[\\d]+[\\S]*\\b"); //типа букви есть или нет скооко хош потом + цифри от 1й и больше и + букви от 0 и скоок хош и все єто отдельно стоящее
        Matcher m;
        while ((line = reader.readLine()) != null){
                m = p.matcher(line);
                while (m.find()){
                    writer.write(m.group() + " ");
                    // или так без последнего пробела writer.write(m.group() + " ", 0, m.group().length + 1;
                }
        }
        reader.close();
        writer.close();
    }
}

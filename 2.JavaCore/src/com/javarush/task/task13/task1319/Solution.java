package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       try {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           String name = reader.readLine();// напишите тут ваш код
           BufferedWriter writer = new BufferedWriter(new FileWriter(new File(name)));

           String line;
           while (!(line = reader.readLine()).equals("exit")){      //!(line = reader.readLine()).equals("exit")
               writer.write(line);                                  //   + "%n"
               writer.newLine();
               }
           writer.write("exit");
           reader.close();
           writer.close();
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }
}

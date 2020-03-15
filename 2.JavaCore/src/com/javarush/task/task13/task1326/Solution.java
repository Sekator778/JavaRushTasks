package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            reader.close();
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file)))); // связка файл в поток поток в буфер ?
            String line;

            while((line = reader1.readLine()) != null){
                int a = Integer.parseInt(line);
                if (a%2 == 0){
                    list.add(a);
                }
            }
            reader1.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
         Collections.sort(list);
        for (Integer a:list) {
            System.out.println(a);
        }
    }

}

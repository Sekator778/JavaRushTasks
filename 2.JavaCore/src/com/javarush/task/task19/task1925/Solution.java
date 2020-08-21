package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String line;
        StringBuilder sb = new StringBuilder();
while ((line = reader.readLine()) != null){                 // читаем сразу в линию и пока она есть
    for (String word : line.split("\\s+")) {        // для всех слов получених с линии разделенних пробелами (регекс)
              if (word.length() > 6) sb.append(word + ",");// если слово длинее чем 6 то стрингбилдером его приклеиваем и взади еще кома
                  }
}
writer.write(sb.toString(),0, sb.length()-1); // стринг билдера пихаем в строку но с 0 до минус один с конца
reader.close();
writer.close();
    }
}

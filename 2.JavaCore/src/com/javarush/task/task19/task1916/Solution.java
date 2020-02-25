package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.*;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(br.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(br.readLine()));
        br.close();

        List<String> file1 = new ArrayList<String>();
        List<String> file2 = new ArrayList<String>();

        while (reader1.ready()) {
            file1.add(reader1.readLine());
        }
        reader1.close();

        while (reader2.ready()) {
            file2.add(reader2.readLine());
        }
        reader2.close();

        int i = 0;
        int j = 0;
        while (i < file1.size() && j < file2.size()) {
            if (file1.get(i).equals(file2.get(j))) {
                lines.add(new LineItem(Type.SAME, file1.get(i)));
                i++;
                j++;
            } else {
                if (j + 1 < file2.size() && file1.get(i).equals(file2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, file2.get(j)));
                    j++;
                } else {
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    i++;
                }
            }
        }
        if (i < file1.size()) lines.add(new LineItem(Type.REMOVED, file1.get(i)));
        if (j < file2.size()) lines.add(new LineItem(Type.ADDED, file2.get(j)));
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
http://tutorials.jenkov.com/java-io/sequenceinputstream.html
*/
public class Solution {
    public static void main(String[] args) {
        File result = new File(args[0]);
        List<String> nameFiles = new ArrayList<>(Arrays.asList(args).subList(1, args.length));
        Collections.sort(nameFiles);
        Vector<FileInputStream> vector = new Vector<>();

        for (String s : nameFiles) {
            try {
                vector.add(new FileInputStream(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try (FileOutputStream fos = new FileOutputStream(result)) {
            try (ZipInputStream zis = new ZipInputStream(new SequenceInputStream(vector.elements()))) {
                byte[] buffer = new byte[2048];
                while (zis.getNextEntry() != null) {
                    int data;
                    while ((data = zis.read(buffer)) != -1) {
                        fos.write(buffer, 0, data);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

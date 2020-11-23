package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // Первый аргумент - полный путь к файлу fileName
        Path fileName = Paths.get(args[0]);
//Добавить файл (fileName) внутрь архива в директорию 'new
        Path newFile = Paths.get("new/ " + fileName.getFileName().toString());
//Второй аргумент - путь к zip-архиву
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);

        Map<ZipEntry, ByteArrayOutputStream> hashMap = new HashMap<>();

        ZipEntry zipEntry;

        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            if (!zipEntry.getName().equals(newFile.toString())) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[2048];
                int length = 0;
                while ((length = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, length);
                }
                byteArrayOutputStream.close();
                hashMap.put(zipEntry, byteArrayOutputStream);
            }
        }
        zipInputStream.close();
        // write zip
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        for (HashMap.Entry<ZipEntry, ByteArrayOutputStream> entry : hashMap.entrySet()) {
            zipOutputStream.putNextEntry(new ZipEntry(entry.getKey().getName()));
            zipOutputStream.write(entry.getValue().toByteArray());
        }
        ZipEntry newEntry = new ZipEntry(newFile.toString());
        zipOutputStream.putNextEntry(newEntry);
        Files.copy(fileName, zipOutputStream);
        zipOutputStream.close();

    }
}

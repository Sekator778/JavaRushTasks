package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("/home/sekator/Downloads/JavaRush"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString); // создаем урл
        InputStream inputStream = url.openStream();  //открываем его на поток
        if (!Files.exists(downloadDirectory)){   // проверить директорию (существует ли она)
            Files.createDirectories(downloadDirectory); // если нет создать
        }
        Path tempFile = Files.createTempFile("temp", ".tmp"); // создание временного файла
        // заливаем в темп файл из потока с пометкой перезапись
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        // создаем имя файлу с реальным именем который пришел в урле после последнего /
        String fileName = urlString.substring(urlString.lastIndexOf("/"));
        // создаем путь полный где создать файл
        Path downloadFile = Paths.get(downloadDirectory.toString() + fileName);
        // перемещаем файл с темпа в реальнный
        Files.move(tempFile, downloadFile, StandardCopyOption.REPLACE_EXISTING);
        // закрываем поток
        inputStream.close();
        return downloadFile;

    }
}

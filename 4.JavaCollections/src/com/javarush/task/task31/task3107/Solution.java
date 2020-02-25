package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try{
            Path path = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(path), Files.isExecutable(path), Files.isDirectory(path),
            Files.isWritable(path));
        } catch (IOException e) {
            e.printStackTrace();
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}

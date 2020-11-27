package com.javarush.task.task34.task3409;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 
Настраиваем логгер
*/

public class Solution {
    public static final Logger LOGGER = LoggerFactory.getLogger(Solution.class);
    public static void main(String[] args) throws IOException {
        String logProperties = "4.JavaCollections/src/" + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/log4j.properties";
        System.out.println(logProperties);
        Path path = Paths.get(logProperties).toAbsolutePath();
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
        }
        LOGGER.info("Test log record!!!");
        LOGGER.error("В программе возникла ошибка!");
        LOGGER.warn("Внимание! Программа пытается разделить одно число на другое");
    }
}

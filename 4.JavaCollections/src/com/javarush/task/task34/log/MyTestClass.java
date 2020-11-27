package com.javarush.task.task34.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyTestClass {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyTestClass.class);

    public static void main(String[] args) {

        LOGGER.info("Начало работы программы!!!");

        try {
            LOGGER.warn("Внимание! Программа пытается разделить одно число на другое");
            System.out.println(12/0);
        } catch (ArithmeticException x) {

            LOGGER.error("Ошибка! Произошло деление на ноль!");
        }
    }
}
package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.javarush.task.task27.task2712.kitchen.Dish.allDishesToString;

//- writeMessage(String message) - для вывода message в консоль
//- String readString() - для чтения строки с консоли
//- List<Dish> getAllDishesForOrder() - просит пользователя выбрать блюдо и добавляет его в список.
public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String inputString = reader.readLine();
        reader.close();
        return inputString;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage("Выберите блюда пожалуйста");
        writeMessage(allDishesToString());
        List<Dish> dishes = new ArrayList<>();
        String dish = "";
        while (!(dish = reader.readLine()).equals("exit")){
            try{
                dishes.add(Dish.valueOf(dish));
            }catch (IllegalArgumentException e){
                writeMessage("Такого блюда нет в меню");
            }

        }return dishes;
    }

}

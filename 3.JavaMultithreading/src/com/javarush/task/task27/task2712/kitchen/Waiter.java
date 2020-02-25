package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {
    @Override
    public void update(Observable observable, Object order) {
        ConsoleHelper.writeMessage(order + " was cooked by " + observable);

    }
}
//3. Метод void update будет выводить в консоль сообщение о том, какой заказ и кем был приготовлен:
//
//order + " was cooked by " + cook
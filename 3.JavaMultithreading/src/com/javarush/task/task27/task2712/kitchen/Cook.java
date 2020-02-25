package com.javarush.task.task27.task2712.kitchen;


import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    String name;

    @Override
    public String toString() {
        return name;
    }

    public Cook(String name) {
        this.name = name;

    }
//Start cooking - Your order: [Soup, Juice, Water] of Tablet{number=5}, cooking time 23min
    @Override
    public void update(Observable observable, Object order) {       //- observable - объект, который отправил нам значение
           ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + ((Order) order).getTotalCookingTime() + "min");        // - arg - само значение, в нашем случае - это объект Order
        setChanged();
        notifyObservers(order);





    }
}

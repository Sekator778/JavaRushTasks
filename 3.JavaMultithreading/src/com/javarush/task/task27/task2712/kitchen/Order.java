package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

import static com.javarush.task.task27.task2712.ConsoleHelper.getAllDishesForOrder;


public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes = getAllDishesForOrder();
    private int duration;

    public int getTotalCookingTime() {
        for (Dish dish : dishes){
            duration = duration + dish.getDuration();
        }
        return duration;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Dish dish : dishes) {
            sb.append(dish).append(", ");
        }
        return String.format("Your order: [%s] of %s", sb.toString().substring(0, sb.length() - 2), tablet.toString());
    }
}

package com.javarush.task.task15.task1520;

/* 
Тренировка мозга1. Результат вывода на экран должен соответствовать условию.
2. В классе Duck должен быть реализован метод doAnotherAction.
3. Метод doAnotherAction() в классе Duck должен выводить на экран строку "Moving".
4. Метод move в классе Util должен вызывать метод doAnotherAction у переданного ему объекта.
5. Класс Duck должен реализовывать интерфейс CanMove.
6. Класс Duck должен реализовывать интерфейс CanFly.
*/

public class Solution {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }

    public static class Duck implements CanFly, CanMove {
        @Override
        public void doAction() {
            System.out.println("Flying");
        }

        @Override
        public void doAnotherAction() {System.out.println("Moving");

        }
    }

    public static class Util {
        static void fly(CanFly animal) {
            animal.doAction();
        }

        static void move(CanMove animal) {
            animal.doAnotherAction();
        }
    }

    public static interface CanFly {
        void doAction();
    }

    public static interface CanMove {
        void doAnotherAction();
    }
}

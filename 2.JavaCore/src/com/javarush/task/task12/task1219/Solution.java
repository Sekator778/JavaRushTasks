package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }


    public class Human implements CanSwim, CanRun{

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Duck implements CanRun, CanSwim, CanFly{

        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Penguin implements CanSwim, CanRun{

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Airplane implements CanRun, CanFly{

        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }
    }
}

package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;


        public Car() throws Exception{
            wheels = new ArrayList<>();
            int wheelCount = 0;
            for (String wh : loadWheelNamesFromDB()){
                wheels.add(Wheel.valueOf(wh));
//                wheelCount += 1;
                wheelCount++;
            }
            if (wheelCount != 4) throw new Exception();

        }

        protected String[] loadWheelNamesFromDB() {

            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
//        Car car = new Car();
    }
}

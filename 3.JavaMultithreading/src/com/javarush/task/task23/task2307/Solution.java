package com.javarush.task.task23.task2307;

import java.time.temporal.Temporal;

/*
Как выбрать нужное?
Как выбрать нужное?
В методе main присвой объекту Object obj экземпляр класса TEST.
Не изменяй ничего кроме метода main.


Требования:
1. В классе Solution должно существовать поле TEST.
2. В классе Solution должен существовать класс TEST.
3. В классе Solution должно существовать поле obj.
4. В методе main в поле obj должен быть сохранен объект типа TEST(экземпляр класса TEST).
*/
public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        TEST test  = new TEST();
        obj = test;
        obj = new Solution.TEST();
        System.out.println(obj);
    }
}

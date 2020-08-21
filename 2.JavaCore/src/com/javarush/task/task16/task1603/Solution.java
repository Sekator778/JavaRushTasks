package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
Список и нити
В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.


Требования:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Метод run класса SpecialThread должен выводить "it's a run method inside SpecialThread".
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        Thread childThreat = new Thread(new SpecialThread());
        list.add(childThreat);

        Thread childThreat1 = new Thread(new SpecialThread());
        list.add(childThreat1);


        SpecialThread specialThread2 = new SpecialThread();
        Thread childThreat2 = new Thread(specialThread2);
        list.add(childThreat2);

        SpecialThread specialThread3 = new SpecialThread();
        Thread childThreat3 = new Thread(specialThread3);
        list.add(childThreat3);

        SpecialThread specialThread4 = new SpecialThread();
        Thread childThreat4 = new Thread(specialThread4);
        list.add(childThreat4);


    }
    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}

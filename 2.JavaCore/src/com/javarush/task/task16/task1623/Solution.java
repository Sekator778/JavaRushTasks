package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
Требования:
1. Класс GenerateThread должен быть унаследован от Thread.
2. В классе GenerateThread должен быть открытый конструктор без параметров.
3. Конструктор класса GenerateThread должен увеличивать значение createdThreadCount и передавать его в виде строки в конструктор суперкласса.
4. Конструктор класса GenerateThread должен запускать нить.
5. Метод toString класса GenerateThread должен возвращать имя нити и слово " created". Пример: "8 created".
6. Если количество созданных нитей меньше Solution.count, метод run должен создать новую нить типа GenerateThread.
7. Если количество созданных нитей меньше Solution.count, метод run должен вывести созданную нить в консоль.
8. Вывод программы должен соответствовать заданию, показывать, что все 15 нитей были созданы.
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {

        public GenerateThread() {
            super(Integer.toString(++createdThreadCount));
            start();
        }


        public void run(){
            if(createdThreadCount < (Solution.count)){
                System.out.println(new GenerateThread());
            }
        }

        public String toString() {
            return getName() + " created";
        }
    }
}

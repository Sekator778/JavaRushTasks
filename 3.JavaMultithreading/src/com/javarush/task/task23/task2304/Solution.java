package com.javarush.task.task23.task2304;

import java.util.List;
import java.util.Map;

/*
Inner 3
Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и MockDB, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и MockDB, цель которого - обновить поле names.


Требования:
1. Класс TaskDataProvider должен быть создан внутри класса Solution и быть приватным.
2. Класс NameDataProvider должен быть создан внутри класса Solution и быть приватным.
3. Класс TaskDataProvider должен реализовывать интерфейс DbDataProvider с параметром типа Task.
4. Класс NameDataProvider должен реализовывать интерфейс DbDataProvider с параметром типа String.
5. Метод refreshAllData в классе TaskDataProvider должен сохранять в список tasks результат работы метода getFakeTasks класса MockDB.
6. Метод refreshAllData в классе NameDataProvider должен сохранять в список names результат работы метода getFakeNames класса MockDB.
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    private class TaskDataProvider implements DbDataProvider<Task>{
            @Override
            public void refreshAllData(Map criteria){
                Solution.this.tasks = MockDB.getFakeTasks(criteria);

        }
    }

    private class NameDataProvider implements DbDataProvider<String>{
        @Override
        public void refreshAllData(Map criteria){
            Solution.this.names = MockDB.getFakeNames(criteria);

        }
    }

    public static void main(String[] args) {

    }

}

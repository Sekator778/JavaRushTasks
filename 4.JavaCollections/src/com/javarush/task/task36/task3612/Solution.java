package com.javarush.task.task36.task3612;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* 
Почему сет не содержит элемент?

*/

/**
 * Почему сет не содержит элемент?
 * ответ дело в хеше обьєкта
 * есть такая общеизвестная проблемка с хэшсетом,
 * В данном случае, перед тем как изменить объект,
 * его нужно удалить из множества, а после добавить снова.
 * Таким образом, он будет записан с корректным хэшкодом.
 */

public class Solution {
    private Set<Date> dates;
    private Date lastDate;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.initializeDates();
        solution.updateLastDate(3_600_000L);
        System.out.println(solution.isLastDateInDates());
    }

    public boolean isLastDateInDates() {
        return dates.contains(lastDate);
    }

    private void initializeDates() {
        dates = new HashSet<>();
        lastDate = new Date(9999999L);
        dates.add(lastDate);
        dates.add(new Date(2222222L));
        dates.add(new Date(3333333L));
        dates.add(new Date(4444444L));
        dates.add(new Date(5555555L));
    }

    protected void updateLastDate(long delta) {
        dates.remove(lastDate);
        lastDate.setTime(lastDate.getTime() + delta);
        dates.add(lastDate);
    }
}

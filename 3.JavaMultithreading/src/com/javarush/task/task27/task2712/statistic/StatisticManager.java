package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

public class StatisticManager {
    private static StatisticManager SINGLETON = null;

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new StatisticManager();
        }
        return SINGLETON;
    }

    public void register(EventDataRow data) {
        
    }
}

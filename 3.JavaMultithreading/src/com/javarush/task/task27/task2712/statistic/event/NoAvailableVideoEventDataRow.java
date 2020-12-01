package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow{
    private final Date currentDate;
    private int totalDuration;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();

    }
}

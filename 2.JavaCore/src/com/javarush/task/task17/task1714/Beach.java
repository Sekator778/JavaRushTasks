package com.javarush.task.task17.task1714;

/* 
Comparable
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        List<Beach> beachList = new ArrayList<>();
        beachList.add(new Beach("one", 900, 5));
        beachList.add(new Beach("two", 1, 5));
        beachList.add(new Beach("three", 2, 5));
//        beachList.add(new Beach("four", 400, 5));
//        beachList.add(new Beach("five", 500, 5));
        System.out.println(beachList);
        Collections.sort(beachList);
        System.out.println("after - " + beachList);

    }

    @Override
    public synchronized int compareTo(Beach beach) {
        int result;
        result = Float.compare(distance, beach.getDistance());
        if (result != 0) return result;
        result = Integer.compare(beach.getQuality(), quality);
        return result;
    }

    @Override
    public synchronized String toString() {
        return "Beach{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", quality=" + quality +
                '}';
    }
}

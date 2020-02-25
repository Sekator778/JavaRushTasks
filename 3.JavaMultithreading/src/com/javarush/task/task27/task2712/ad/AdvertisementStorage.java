package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static final AdvertisementStorage instance = new AdvertisementStorage();

    private final List<Advertisement> videos = new ArrayList();

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 10000, 10, 10 * 60)); //10 min
        add(new Advertisement(someContent, "Fourth Video", 1500, 5, 30 * 60));
        add(new Advertisement(someContent, "Fifth Video", 4000, 10, 2 * 60));
        add(new Advertisement(someContent, "Seventh Video", 2500, 10, 20 * 60));
        add(new Advertisement(someContent, "Eight Video", 3000, 5, 36 * 60));
        add(new Advertisement(someContent, "Ninth Video", 500, 5, 3 * 60));
        add(new Advertisement(someContent, "Ten Video", 4500, 10, 18 * 60));
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            return new AdvertisementStorage();
        }
        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        list().add(advertisement);
    }
}

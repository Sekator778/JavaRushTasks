package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {// 6lyat
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        List<Advertisement> videos = new ArrayList<>();
        for (Object video : storage.list()) {
            videos.add((Advertisement) video);
        }
        videos.sort(Comparator.comparingInt(Advertisement::getDuration));
        videos.sort(((o1, o2) -> (int) (o1.getAmountPerOneDisplaying() - o2.getAmountPerOneDisplaying())));
        Collections.reverse(videos);
        int freeTime = timeSeconds;

        for (Advertisement video : videos) {
            if (video.getDuration() <= freeTime && video.getAmountPerOneDisplaying() > 0){
                System.out.println(video.getName() + " is displaying... " + video.getAmountPerOneDisplaying() + ", " +
                video.getAmountPerOneDisplaying() * 1000 / video.getDuration());
                video.revalidate();
                freeTime -= video.getDuration();
            }
        }

    }
}

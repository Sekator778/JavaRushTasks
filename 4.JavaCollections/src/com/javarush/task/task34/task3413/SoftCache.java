package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private final Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        return softReference != null ? softReference.get() : null;
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        if (softReference == null) {
            return null;
        }
        AnyObject object = softReference.get();
        softReference.clear();
        return object;
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        if (softReference == null) {
            return null;
        }

        AnyObject oldValue = softReference.get();
        softReference.clear();

        return oldValue;
    }
}
package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapStorageStrategy implements StorageStrategy {
    private final HashMap<Long, String> data;

    public HashMapStorageStrategy() {
        this.data = new HashMap<>();
    }

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        for(Long key : data.keySet()){
            if(Objects.equals(data.get(key), value)){
                return key; //return the first found
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}

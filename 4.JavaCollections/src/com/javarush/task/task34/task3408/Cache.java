package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private final Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
       return cache.getOrDefault(key, (V) clazz); //TODO add your code here
    }

    public boolean put(V obj) {
        //TODO add your code here
        return false;
    }

    public int size() {
        return cache.size();
    }
}

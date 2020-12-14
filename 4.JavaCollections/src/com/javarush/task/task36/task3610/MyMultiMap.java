package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        List<V> list = map.get(key);
        V current;
        if (list != null) {
            current = list.get(list.size() - 1);
        } else {
            list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
            return null;
        }
        if (map.containsKey(key) && map.get(key).size() < repeatCount) {
            list.add(value);
            return current;
        } else if (map.containsKey(key) && map.get(key).size() == repeatCount) {
            list.remove(0);
            list.add(value);
            return current;
        }
        return null;
        //напишите тут ваш код
    }

    @Override
    public V remove(Object key) {
        if (map.get(key) != null) {
            List<V> list = map.get(key);
            V temp = list.remove(0);
            if (list.isEmpty()) {
                map.remove(key);
            }
            return temp;
        } else {
            return null;
        }
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        Collection<V> vs = new ArrayList<>();
        map.forEach((key, value) -> vs.addAll(value));
        return vs; //напишите тут ваш код
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);//напишите тут ваш код
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);//напишите тут ваш код
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}
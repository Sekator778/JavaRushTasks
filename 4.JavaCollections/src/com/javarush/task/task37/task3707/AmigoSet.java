package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        init(Math.max((int) (collection.size() / .75f) + 1, 16));
        addAll(collection);
    }

    private void init(int capacity) {
        this.map = new HashMap<>(capacity);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    public boolean add(E e) {
        boolean result = map.containsKey(e);
        if (!result) this.map.put(e, PRESENT);
        return !result;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> set = (AmigoSet<E>) super.clone();
            set.map = (HashMap<E, Object>) map.clone();
            return set;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity"));
        stream.writeFloat(HashMapReflectionHelper.<Float>callHiddenMethod(map, "loadFactor"));
        stream.writeInt(map.size());
        for(E e :map.keySet()){
            stream.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int capacity = stream.readInt();
        float loadFactor = stream.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        int size = stream.readInt();
        for (int i = 0; i < size; i++) {
            map.put((E) stream.readObject(), PRESENT);
        }
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        map.forEach((k, v) -> {
            result.append("key: ").append(k).append(" : ").append("value: ").append(v);
        });
        return result.toString();
    }
}

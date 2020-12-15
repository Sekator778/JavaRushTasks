package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private String value;
    private int id;
    private Long lastId = 0l;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    /**
     * Проверить есть ли переданное значение в хранилище, если есть - вернуть его ключ.
     * 3.4.2. Если преданного значения нет в хранилище, то:
     * 3.4.2.1. Увеличить значение lastId на единицу;
     * 3.4.2.2. Добавить в хранилище новую пару ключ-значение (новое значение lastId и переданную строку);
     * 3.4.2.3. Вернуть новое значение lastId.
     *
     * @param string переданное значение в хранилище
     * @return - lastId
     */
    public synchronized Long getId(String string) {
        if (this.storageStrategy.containsValue(string)) {
            return this.storageStrategy.getKey(string);
        } else {
            lastId++;
            this.storageStrategy.put(lastId, string);
            return lastId;
        }
    }

    /**
     * 3.5. Реализуй метод getString, он должен вернуть строку по заданному идентификатору (ключу).
     * 3.6. Предусмотреть возможность вызова методов getId и getString из разных потоков добавив
     * соответствующий модификатор к заголовкам методов.
     *
     * @param id
     * @return
     */
    public synchronized String getString(Long id) {
        return this.storageStrategy.getValue(id);
    }
}

package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Реализовать логику метода convertOneToAnother, который должен возвращать объект класса resultClassObject,
 * значения полей которого равны значениям полей в объекте one.
 * Используй объект типа ObjectMapper.
 * Известно, что у классов есть JSON аннотация, у которой значение property равно имени класса в нижнем регистре.
 * На примере класса First, это className="first"
 * Классы First и Second не участвуют в тестировании, они предоставлены в качестве тестовых данных.
 *
 *
 * Требования:
 * 1. Метод convertOneToAnother должен возвращать объект класса resultClassObject значения полей которого равны значениям полей объекта one.
 * 2. В методе convertOneToAnother должен быть создан объект типа ObjectMapper.
 * 3. Метод convertOneToAnother должен быть статическим.
 * 4. Метод convertOneToAnother должен быть публичным.
 *
 * оце блядь накуренні чуваки !
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, one);

        String oneClassName = one.getClass().getSimpleName().toLowerCase();
        String resultClassName = resultClassObject.getSimpleName().toLowerCase();

        String replaceString = writer.toString().replaceFirst(oneClassName, resultClassName);

        return mapper.readValue(new StringReader(replaceString), resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i;
        public String name;
    }
}

package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(HumanFactoryType type) {
        if (type == HumanFactoryType.MALE) {
            return new MaleFactory();
        }
        if (type == HumanFactoryType.FEMALE) {
            return new FemaleFactory();
        } else {
            throw new IllegalArgumentException("mudak 2");
        }
    }
    public static enum HumanFactoryType {
        MALE, FEMALE;
    }
}

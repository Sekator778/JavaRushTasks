package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

//Добавь в класс ImageReaderFactory открытый статический метод getImageReader с параметром ImageTypes.
public class ImageReaderFactory {
    public static ImageReader getImageReader (ImageTypes types) {
        if (types == null) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }else
            switch (types) {
                case BMP: return new BmpReader();
                case JPG: return new JpgReader();
                case PNG: return new PngReader();

                default: throw new IllegalArgumentException("Неизвестный тип картинки");
            }

    }
}

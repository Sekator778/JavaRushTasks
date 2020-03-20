package com.javarush.task.task18.task1817;

/* 
Пробелы
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
4. Выведенное значение необходимо округлить до 2 знаков после запятой.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countSpace = 0, countSimvol = 0;
        char current = 0;
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        countSimvol = fileInputStream.available();                          // количество всех символов в файлу
        while (fileInputStream.available() > 0){

            current = (char) fileInputStream.read();                        // делаем чар из бита
            if (current == ' ')countSpace++;                               // проверяем или такой как нам надо чар

        }
        fileInputStream.close();
        System.out.format("%.2f", 1.0*countSpace/countSimvol*100);

    }
}

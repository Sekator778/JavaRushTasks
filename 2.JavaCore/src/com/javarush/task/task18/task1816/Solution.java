package com.javarush.task.task18.task1816;

/* 
Английские буквы
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        char ch = 0;
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        while (fileInputStream.available() > 0){
            int i = fileInputStream.read();
            if  ((i >= 97 && i <= 122)||(i >= 65 && i <= 90)){           // все букви англ словаря  или так if  ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
                count++;
            }
        }
        fileInputStream.close();
        System.out.println(count);
    }
}

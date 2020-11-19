package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static String fileName;

    /**
     * в мейне читаем аргументы
     *
     * @param args - тут они ключи
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            return;
        }
        fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if ("-u".equals(args[0])) {
            updateById(getNewString(getRequestParameters(args)));
        }
        if ("-d".equals(args[0])) {
            deleteById(args[1]);
        }
    }

    /**
     * по айди при прохождении по всем строкам файла если нету совпадения
     * то оставляем строку добавлением в масив
     * если совпало игнорим
     *
     * @param id - строки которая не попадет в новый масив на запись
     */
    private static void deleteById(String id) {
        List<String> allFileStrings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null)
                if (!(line.substring(0, 8).trim()).equals(id))
                    allFileStrings.add(("\n" + line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        firstLineFormat(allFileStrings);
        writeFile(allFileStrings);
    }

    /**
     * лист строк записываем в файл по имени
     *
     * @param allFileStrings - имя файла - лист строк (таблица)
     */
    private static void writeFile(List<String> allFileStrings) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : allFileStrings) {
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * новая строка которая пришла в агрументах заменяем вместо старую
     * при совпадении куска строки где именно айди (0, 8)
     */
    private static void updateById(String newString) {
        String id = newString.substring(0, 8).trim();
        List<String> allFileStrings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                allFileStrings.add(line.substring(0, 8).trim().equals(id) ? line.replaceAll(line, newString) : ("\n" + line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        firstLineFormat(allFileStrings);
        writeFile(allFileStrings);
    }

    private static void firstLineFormat(List<String> allFile) {
        if (allFile.get(0).charAt(0) == '\n') {
            allFile.set(0, allFile.get(0).replace("\n", ""));
        }
    }

    /**
     * дикий джаварашовский шаблон табличной строки - по условию смотрите
     */
    private static String getNewString(List<String> requestParameters) {
        return String.format("%n%-8s%-30s%-8s%-4s",
                requestParameters.get(0),
                requestParameters.get(1),
                requestParameters.get(2),
                requestParameters.get(3));
    }

    private static List<String> getRequestParameters(String[] args) {
        List<String> parameters = new ArrayList<>(4);
        parameters.add(args[1]);
        parameters.add(args[2].substring(0, Math.min(args[2].length(), 30)));
        parameters.add(args[3]);
        parameters.add(args[4]);
        return parameters;
    }
}

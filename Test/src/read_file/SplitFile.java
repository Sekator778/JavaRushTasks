package read_file;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

/**
 * Читаем файл разбиваем на отдельные слова выводим на экран
 */
public class SplitFile {
    private static final String DATE_FORMAT_NOW = "dd-MM-yyyy-HH-mm";

    public static void main(String[] args) throws IOException {
        SplitFile worker = new SplitFile();
        worker.printToConsoleFiveFirstChar(readFileToTreeSet("text1.txt"));
        worker.saveWorkToFile(readFileToTreeSet("text1.txt"));
    }

    /**
     * Читаем и сортируем только уников в сете
     *
     * @param fileName - имя файла
     * @return - сет слов
     */
    private static TreeSet<String> readFileToTreeSet(String fileName) {
        TreeSet<String> result = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\W+")) {
                    if (word.length() < 3) {
                        continue;
                    }
                    result.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * вывод на экран
     */
    private void printToConsoleFiveFirstChar(TreeSet<String> strings) {
        int count = 0;
        for (String word : strings) {
            count++;
            System.out.printf("%d\t %s\n", count, word);
        }
    }

    /**
     * запись результата в файл
     */
    private void saveWorkToFile(TreeSet<String> strings) {
        String filenameBase = "myDictionary";
        String currentTimestamp = now();
        File fileName = new File(filenameBase + currentTimestamp + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String s : strings
            ) {
                writer.write(s + "\t" + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * добавление к имени файла времени метку
     *
     * @return - текущая дата
     */
    private String now() {
        return new SimpleDateFormat(DATE_FORMAT_NOW).format(new Date());
    }
}


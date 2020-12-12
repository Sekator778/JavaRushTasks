package read_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TreeSet;

import static java.time.LocalTime.now;

/**
 * Читаем файл разбиваем на отдельные слова выводим на экран
 */
public class SplitFile {
    public static void main(String[] args) throws IOException {
        new SplitFile().printToConsoleFiveFirstChar(readFileToTreeSet("text1.txt"));
    }

    /**
     * Читаем и сортируем только уников в сете
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

    private void saveWorkToFile(TreeSet<String> strings) {
        String filenameBase = "myDictionary";
        String currentTimestamp = new SimpleDateFormat("yyyymmddHHMMss").format(now());
        File f = new File(filenameBase + currentTimestamp +  ".png");
    }
}


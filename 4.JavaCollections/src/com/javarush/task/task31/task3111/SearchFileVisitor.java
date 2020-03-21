package com.javarush.task.task31.task3111;
//1. В классе SearchFileVisitor нужно создать поля partOfName, partOfContent, minSize, maxSize и сеттеры для них.
//2. В классе SearchFileVisitor нужно создать поле foundFiles и геттер для него. Поле должно быть сразу инициализировано.
//3. Если в SearchFileVisitor задан критерий поиска partOfName, метод visitFile должен добавить файл в foundFiles, если в названии содержится строка partOfName.
//4. Если в SearchFileVisitor задан критерий поиска partOfContent, метод visitFile должен добавить файл в foundFiles, если в содержимом встречается строка partOfContent.
//5. Если в SearchFileVisitor задан критерий поиска maxSize, метод visitFile должен добавить файл в foundFiles, если размер файла меньше maxSize.
//6. Если в SearchFileVisitor задан критерий поиска minSize, метод visitFile должен добавить файл в foundFiles, если размер файла больше minSize.
//7. Метод visitFile должен быть реализован так, чтобы учитывать сразу несколько критериев поиска.
import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    /**
     * класный продвинутый поиск джава раш тебе за это +
     * тут прикол с полями этого класа  SearchFileVisitor
     *
     * если задали поле какоето то ставим флаг булен
     * и в visitFile уже чекаем это все хозяйство и аадд  в лист
     */
    private List<Path> foundFiles = new ArrayList<>();
private String partOfName;
private String partOfContent;

private int minSize;
private int maxSize;
boolean minSizeCheck;
boolean maxSizeCheck;
boolean partOfNameCheck;
boolean partOfContentCheck;

    public SearchFileVisitor() {
        this.partOfName = null;
        this.partOfContent = null;
        this.minSize = 0;
        this.maxSize = 0;
        this.minSizeCheck = false;
        this.maxSizeCheck = false;
        this.partOfNameCheck = false;
        this.partOfContentCheck = false;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        this.partOfNameCheck = true;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        this.partOfContentCheck = true;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        this.minSizeCheck = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        this.maxSizeCheck = true;
    }

    public List<Path> getFoundFiles() {
        return this.foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (!attrs.isRegularFile()) return CONTINUE;

        if (partOfNameCheck && !file.getFileName().toString().contains(this.partOfName))
            return CONTINUE;

        if (minSizeCheck && attrs.size() < minSize)
            return CONTINUE;

        if (maxSizeCheck && attrs.size() > maxSize)
            return CONTINUE;

        if (partOfContentCheck && !new String(Files.readAllBytes(file)).contains(partOfContent))
            return CONTINUE;

        foundFiles.add(file);

        return CONTINUE;
    }
//--------------------------------------------------

}

package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        reader.close();
        if (!Files.isDirectory(path)){
            System.out.println(path.toAbsolutePath().toString() + " - не папка");
        }else {
            MyFileVisitor visitor = new MyFileVisitor();
            // вот оно самое важное путь и как там ходить парню по имени walkFileTree
            Files.walkFileTree(path, visitor);

            System.out.println("Всего папок - " + visitor.getDirectories());
            System.out.println("Всего файлов - " + visitor.getFiles());
            System.out.println("Общий размер - " + visitor.getSize());

            // тут пробовал леипить стримы как суму считать сайзов не допер сам
//            Stream<Path> pathStream = Files.walk(path);
//            int countDirectory = (int) pathStream
//                    .filter(Files::isDirectory)
//                    .count() - 1;
//            System.out.println("Всего папок - "+ countDirectory);
//
//            Stream<Path> pathStream1 = Files.walk(path);
//            int countFile = (int) pathStream1
//                    .filter(Files::isRegularFile)
//                    .count();
//            System.out.println("Всего файлов - "+ countFile);

        }

    }
}
// ниже метод реализация класса SimpleFileVisitor и перееопределения
// его хитрых методов которые лазяют по деревьях
 class MyFileVisitor extends SimpleFileVisitor<Path> {
    private int directories = -1; // тут -1 чтобы не считать ту с которой начали проход
    private int files = 0;
    private long size = 0;
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        files++;
        size += Files.size(file);
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        directories++;
        return super.preVisitDirectory(dir, attrs);
    }
//(третий -visitFileFailed чтобы не выкидывал эксепшены при отказе допуска)
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.SKIP_SUBTREE;
    }

    public int getDirectories() {
        return directories;
    }

    public int getFiles() {
        return files;
    }

    public long getSize() {
        return size;
    }
}

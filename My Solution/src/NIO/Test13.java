package NIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileFindVisitor extends SimpleFileVisitor<Path> {
    static  int count = 0;

    private PathMatcher matcher;

    public MyFileFindVisitor(String pattern) {
        try {
            matcher = FileSystems.getDefault().getPathMatcher(pattern);
        } catch (IllegalArgumentException iae) {
            System.err
                    .println("Invalid pattern; did you forget to prefix \"glob:\" or \"regex:\"?");
            System.exit(1);
        }

    }

    public FileVisitResult visitFile(Path path,
                                     BasicFileAttributes fileAttributes) {
        find(path);
        return FileVisitResult.CONTINUE;
    }

    private void find(Path path) {
        Path name = path.getFileName();
        if (matcher.matches(name))
            System.out.println("Matching file:" + path.getFileName());
    }

    public FileVisitResult preVisitDirectory(Path path,
                                             BasicFileAttributes fileAttributes) {
        find(path);
        count++;

        return FileVisitResult.CONTINUE;
    }
}

public class Test13 {
    public static void main(String[] args) {
        Path startPath = Paths.get("/home/sekator/");

        //Строка с glob-шаблоном
        String pattern = "glob:*.java";

        //Строка с regex-шаблоном
        //String pattern = "regex:\\S+\\.java";

        try {
            Files.walkFileTree(startPath, new MyFileFindVisitor(pattern));
            System.out.println("File search completed!");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("count = " + MyFileFindVisitor.count);
    }
}
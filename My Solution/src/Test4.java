import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test4 {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("/home/sekator/Java/JavaRushTasks/My Solution/src/file1.txt")).forEach(System.out::println);
    }
}

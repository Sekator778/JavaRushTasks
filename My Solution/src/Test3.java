import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Test3 {
    public static void main(String[] args) throws IOException {
       List<String> list = Files.readAllLines(Paths.get("/home/sekator/Java/JavaRushTasks/My Solution/src/file1.txt"));

       for (String s : list) {
           System.out.println(s);
       }
    }
}

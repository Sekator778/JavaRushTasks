import java.io.FileInputStream;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new FileInputStream("/home/sekator/Java/JavaRushTasks/My Solution/src/file1.txt"));

        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }

}

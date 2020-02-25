import java.io.FileReader;
import java.io.IOException;

public class IOstream {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("test3.txt");
        int c = fr.read();
        System.out.println("int " + c);
        char ch = (char) c;
        System.out.println("char " + ch);
        fr.close();
    }
}

package WorkFile;

import java.nio.file.*;

public class Test {
    public static void main(String[] args) throws Exception {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/home/sekator/test folder")))
        {
            for (Path filePath : stream){
                String fileName = filePath.getFileName().toString();
                System.out.println("processing file: name = " + fileName + ", size = " + Files.size(filePath) + " bytes");
//                Files.copy(filePath, Paths.get("income", fileName));
                Files.write(Paths.get("log1212.txt"), ("processing file: name = " + fileName + ", size = " + Files.size(filePath) + " bytes" + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            }
        }
    }
}

package NIO;

public class Test1 {
    public static void main(String[] args) {

        // Cоздание объекта Path через вызов статического метода get() класса Paths
        Path testFilePath = Paths.get("/home/Sekator/test/test1.txt");

        //Пример строки создания объекта Path пути для запуска в Windows
        //Path testFilePath = Paths.get("D:\\test\\testfile.txt");

        //Вывод инормации о файле
        System.out.println("Printing file information: ");
        System.out.println("\t file name: " + testFilePath.getFileName());
        System.out.println("\t root of the path: " + testFilePath.getRoot());
        System.out.println("\t parent of the target: "
                + testFilePath.getParent());

        //Вывод элементов пути
        System.out.println("Printing elements of the path: ");
        for (Path element : testFilePath) {
            System.out.println("\t path element: " + element);
        }
    }
}
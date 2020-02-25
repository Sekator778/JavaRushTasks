public class Test5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("test1.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line.replaceAll("o", "X"));
        }
        reader.close();
        // out to file
        BufferedWriter writer = new BufferedWriter(new FileWriter("test1.txt", true));
        writer.write("\nI love Too");
        writer.close();
    }
}

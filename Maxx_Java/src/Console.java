public class Console {
    public static void main(String[] args) {
        java.io.Console console = System.console();
        String s = "";
        while (!s.equals(("exit"))){
            s = console.readLine();
            System.out.println(s);
        }
    }
}

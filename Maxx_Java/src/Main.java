public class Main {

    private int j = 9;


    public static void main(String[] args) {
//        new Main().method();
        new Second().method23();
    }

    class Inner {
        private int g = 1;
        void methof() {
            System.out.println(j);
        }
    }
    void method() {
        new Inner().methof();
    }
}

class Second {
    void method23() {
        System.out.println("Privet iz 23 classa i toge j = ");
        Main.Inner inner23 = new Main().new Inner();
        inner23.methof();
    }
}

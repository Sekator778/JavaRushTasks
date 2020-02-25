public class happensBefore {
    static int a = 0;
    static int b = 0;


    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {


            new Thread() {
                @Override
                public void run() {
                    int r2 = a;
                    b = 1;
                    System.out.println("r2 = " + r2);

                }

            }.start();
            new Thread() {
                @Override
                public void run() {
                    int r1 = b;
                    a = 2;
                    System.out.println("r1 = " + r1);

                }
            }.start();
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("-------------------------");
        }
    }//r2 == 2 && r1 == 1
}

public class ArithmeticalDemo {
    public static void main(String[] args) {
//        int x = -1;
//        String binaryString = Integer.toBinaryString(x);
//        System.out.println("int = " + x + " binary = " + binaryString);

            int a = 1;

            System.out.println(" a = " + a + "; binary string: " + Integer.toBinaryString(a));
            System.out.println("~a = " + ~a + "; binary string: " + Integer.toBinaryString(~a));

        System.out.println(277&432);
        int x = 64;//значение
        int y = 3;//количество

        int z = (x << y);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(z));
        System.out.println(111111111 << 3);


    }
}

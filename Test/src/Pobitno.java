import java.math.BigInteger;

public class Pobitno {
    public static void main(String[] args) {
        int x = 20;
        System.out.println(Integer.toBinaryString(x));

        System.out.println(Integer.toBinaryString(~x));
        System.out.println("length Integer: " + String.valueOf(Integer.toBinaryString(~x)).length());
        System.out.println(277&432);
        System.out.println(277|432);
        int x1 = 64;//значение
        int y = 2;//количество

        int z = (x1 >> y);
        System.out.println(z);
        System.out.println(35 >> 2);
        System.out.println("===================");
        String x2 = Integer.toBinaryString(x);
        System.out.println(x2);
        BigInteger bigInteger = new BigInteger(x2, 2);

        System.out.println(bigInteger);

        System.out.println("Битовые маски,…");
        boolean a = true;
        boolean b = false;
        boolean c = true;
        boolean d = false;
     //   Упаковка их в одно число:
        int result = 0;
        if (a) result += 1; //1 == 20 — нулевой бит true
        if (b) result += 2; //2 == 21 — первый бит  false
        if (c) result += 4; //4 == 22 — второй бит  true
        if (d) result += 8; //8 == 23 — третий бит  false

        System.out.println(result);
        System.out.println("установка битов ");

        int a1 = 9;

        System.out.println("after: " + Integer.toBinaryString(a1) + " "+ a1);
        a1 |= (1<<2); // установить в 1 бит 2
        System.out.println(Integer.toBinaryString(a1) + " "+ a1);

        int a2 = 15;
        System.out.println("after: " + Integer.toBinaryString(a2) + " "+ a2);

        a2 &= ~(1<<2); // установить в 0 бит 2
        System.out.println(Integer.toBinaryString(a2) + " "+ a2);

    }
}

import java.math.BigInteger;

public class perevodVSistemyIschislenia {
    public static void main(String[] args) {
//Как преобразовать число из X-й системы в Y-ю?
        System.out.println(new BigInteger("81985529216486895", 10).toString(8)); //   1-4)
        System.out.println(new BigInteger("4432126361152746757", 16).toString(10)); //      5-9)
    }
}

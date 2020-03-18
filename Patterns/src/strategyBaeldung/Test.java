package strategyBaeldung;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        Discounter easterDiscounter = new EasterDiscounter();

        BigDecimal discountedValue = easterDiscounter
                .applyDiscount(BigDecimal.valueOf(100));

        System.out.println(discountedValue);
//                .isEqualByComparingTo(BigDecimal.valueOf(50));
    }
}

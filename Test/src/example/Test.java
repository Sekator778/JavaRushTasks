package example;

/**
 *
 */

public class Test {
    public static void main(String[] args) {
        int[] mas = {120, 200, 016};
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i] + " ");
        }
        System.out.println(Integer.MIN_VALUE < Double.MAX_VALUE);

        double[][] ad = new double[100][5];
        double[][] ad2 = new double[5][100];
        System.out.println("ad " + ad.length);
        System.out.println("ad2 " + ad2.length);

    }
}

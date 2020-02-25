import java.util.Random;

class Test2 {
    public static void main(String[] args) {
        Random r = new Random();
        int random = r.nextInt(100);
        System.out.println(random);
        int x = 9;
        x = x/=3;
        System.out.println(x);

        double inf = Double.POSITIVE_INFINITY;
        System.out.println(inf); // Бесконечность
        System.out.println(inf + 1); //Бесконечность+1 ==Бесконечность
        System.out.println(inf + 10); //Бесконечность+10 ==Бесконечность
        System.out.println(inf * -1); //равно «минус бесконечность»
        System.out.println(Double.NEGATIVE_INFINITY);

        double inf1 = 0.0;
        System.out.println(inf1 / -inf1);
        System.out.println(9.9889 / inf1);
    }
}
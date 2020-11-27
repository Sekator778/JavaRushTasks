package strings;

/**
 * https://developernotes.ru/java/stroki-string-v-java-osobennosti-promlemi-pul-strok-sozdanie-i-rabota-so-strokami
 * Строки это важно !!!
 * Еще разок не помешает почитать
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "s1";
        String s2 = s1;
        System.out.println("s1 == s1 " + s1 == s2);
        System.out.println("s1.equals(s2) " + s1.equals(s2));

        String s3 = new String("s1");
        String s4 = "s1";

        System.out.println("s1.equals(s3) " + s1.equals(s3));
        System.out.println("s1.equals(s4) " + s1.equals(s4));

        String text = "Это очень важное сообщение";
        String message = new String ("Это очень важное сообщение");

        System.out.println("this is references to different strings -> " + (text == message));
        System.out.println("this is pool string -> " + text.equals(message));
        System.out.println("##################################");

        String something = "Something";
        String s = new String(something);
        if (something == s) System.out.println("something == s");
        if (something.equals(s)) System.out.println("something.equals(s)");

        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);

        String a = new String("abc");
        String b = new String("abc");
        System.out.println (a == b);


    }
}

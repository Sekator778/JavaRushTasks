public class Pobitam {

    public static void main(String[] args) {
        //Посмотрим сначала простые примеры типов c литералами
        printType(1);
        printType(0b10); //двоичная система (начинаются с 0b), однако все системы счиления воспринимаются как int
        printType(03);   //восмиричная (начинаются с нуля)
        printType(0x4);  //шестнадцатиричная (начинаются с 0x)
        printType(5f);
        printType(6L);
        printType(7D);
        printType((char)65);  //Символ 'A' в системе ASCII

        System.out.println(); //отступим строку, чтобы не запутатся при просмотре консоли

        //Теперь поиграем с преобразованиями
        printType((byte)6+3);   //в выражении есть тип выше, поэтому всё расширится до него
        printType((short)5+5L); //дальше по аналогии
        printType((short)3+(float)8);
        printType((byte)2+(char)1+2f+3L+4D);

        System.out.println();

        //Любая операция расширяет минимум до int, если они меньше этого типа
        printType((byte)5+(short)8);
        printType((char)10+(char)4);

        System.out.println();

        //Либо до большего типа, если он есть
        printType((char)7+(float)8);
        System.out.println(" ---------------- New ---------------------");
        double a = 2.718281828459045;
        double d = 4.05E-13;
        System.out.println("Тип double в классическом виде: " + a);
        System.out.println("Тип double в научном виде: " + d);
        System.out.println(" ------------------ Строковие литерали -------------------------");
        String simpleString = "Это обычная строка. Такая же стандартная и непримечательная, как и все мы.";
        String uniqueString = "А это необычная \"строка\". Хотя бы потому, что часть \"слов\" в ней в \"кавычках\".";
        System.out.println(simpleString);
        System.out.println(uniqueString);
        System.out.println("Амперсанд - " + '&');
        System.out.println("Символ деления - " + '\u00F7');
        //----------------------
        int smile = 0x1F600; // Здесь шестнадцатеричный код эмоджи
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toChars(smile)); // Собираем в StringBuilder
        System.out.println("Улыбающееся лицо: " + sb.toString()); // Выводим



    }
    public static void printType(byte num) {
        System.out.println(num+" — byte");
    }
    public static void printType(short num) {
        System.out.println(num+" — short");
    }
    public static void printType(char num) {
        System.out.println(num+" — char");
    }
    public static void printType(int num) {
        System.out.println(num+" — int");
    }
    public static void printType(long num) {
        System.out.println(num+" — long");
    }
    public static void printType(float num) {
        System.out.println(num+" — float");
    }
    public static void printType(double num) {
        System.out.println(num+" — double");
    }

}

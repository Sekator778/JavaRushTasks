package thisexample;

public class This_Example {
    // Инициализация переменной num
    int num = 11;

    This_Example() {
        System.out.println("Это пример программы с ключевым словом this");
    }

    This_Example(int num) {
        // Вызов конструктора по умолчанию
        this();

        // Присвоение локальной переменной num переменной экземпляра num
        this.num = num;
    }

    public void greet() {
        System.out.println("Привет! Добро пожаловать на ProgLang!");
    }

    public void print() {
        // Локальная переменная num
        int num = 20;

        // Вызов метода класса greet
        this.greet();

        // Вывод локальной переменной.
        System.out.println("Значение локальной переменной num: " + num);

        // Вывод переменной экземпляра.
        System.out.println("Значение переменной экземпляра num: " + this.num);
    }

    public static void main(String[] args) {
        // Инициализация класса
        This_Example obj1 = new This_Example();

        // Вызов метода print
        obj1.print();

        // Передача нового значения переменной num через параметризованный конструктор
        This_Example obj2 = new This_Example(30);

        // Вызов снова метода print
        obj2.print();
    }
}
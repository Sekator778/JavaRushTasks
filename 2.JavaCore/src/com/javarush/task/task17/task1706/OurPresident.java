package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;

    private OurPresident() {
    }

    public  static OurPresident getOurPresident() {
        return president;
    }
    static {
        synchronized (OurPresident.class) {
            president = new OurPresident();
        }
    }

}
/*
а теперь подробно, что происходит в классе OurPresident в хронологическом порядке:

0. на класс OurPresident была сделана ссылка из другого кода, возникла необходимость инициировать класс. Например, был выполнен вызов метода класса
public static OurPresident getOurPresident() {
        return president;
    }

1.
private static OurPresident president;

статическое поле класса, выполняется только один раз на этапе инициации класса
2.
static {
        synchronized (OurPresident.class) {
            president = new OurPresident();
        }
    }

статический блок класса, выполняется только один раз на этапе инициации класса
поскольку блок содержит new OurPresident(), направляемся в конструктор класса
3.
private OurPresident() {
    }

выполняем конструктор класса (доступен только из кода класса, ибо private), создается экземпляр класса (=объект класса)
4. опять статический блок
president = new OurPresident();

указательссылку на созданный объект сохраняем на переменной president в статическом блоке
5. завершение шага 0. передача ссылки на объект классаt.
*/

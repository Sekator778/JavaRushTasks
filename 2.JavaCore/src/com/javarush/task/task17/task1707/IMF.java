package com.javarush.task.task17.task1707;
//МВФprivate static IMF imf;
//// 1. Класс IMF должен содержать приватное статическое поле IMF imf.
//
//public static IMF getFund()
//// 3. Класс IMF должен содержать публичный статический метод IMF getFund().
//{
//    synchronized (IMF.class) // 4. Метод getFund() должен содержать синхронизированный блок.
//    {// 5. Внутри синхронизированного блока должно быть проинициализировано поле imf.
//        if (imf == null) // это от singletone паттерн, если он уже есть, то не создаем новый объект
//            // подробно разные примеры см по ссылкам, аля https://habrahabr.ru/post/27108/
//        {
//            imf = new IMF();
//        }
//        return imf; // 6. Метод getFund() должен всегда возвращать один и тот же объект.
//    }
//}
//
//private IMF()
//// 2. Класс IMF должен содержать приватный конструктор.
//{
//}


public class IMF {

    private static IMF imf;             //1

    public static IMF getFund() {       //3
        synchronized (IMF.class){       //4
          if (imf == null) imf = new IMF(); //5
        }//add your code here - добавь код тут
        return imf;
    }

    private IMF() {                         //2
    }
}

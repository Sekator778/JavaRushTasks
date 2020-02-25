public class Tenp {

//     static class OuterStaticInit {
//        static {
//            class LocalInit {
//                LocalInit() {
//                    System.out.println("From static iniz");
//                }
//            }
//            LocalInit localInit = new LocalInit();
////            System.exit(0);
//        }
//
//        public static void main(String[] args) {
//            System.out.println("From main");
//        }
//    }
//public static class OuterLocal {
//    OuterLocal(){
//
//        /*объявление локального класса в конструкторе OuterLocal*/
//        class LocalInnerClass {
//            LocalInnerClass(){}
//        }
//        /* создаем экземпляр в том же блоке*/
//        LocalInnerClass localObj = new LocalInnerClass();
//    }
//
//
//    public static void main(String[] args) {
//        OuterLocal ol = new OuterLocal();
//
//        // вне области видимости содержащего его блока
//    }
}
class Outer1 {

    public static void main(String[] args) {
        Runnable anonym = () -> {
        };

        String str = anonym.getClass().toString();
        System.out.println(str);
    }
	  /*  раскомментировать если не поддерживается лямбда
            public static void main(String[] args)
            {
              Runnable anonym = new Runnable() {
               public void run() {
                                }
                };
              */
}


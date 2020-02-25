package com.javarush.task.task24.task2405;

/* 
Black box
*/
//public class Solution implements Action {
//    public static int countActionObjects;
//
//    private int param;
//
//    private Action solutionAction = new Action() {
//        //!!!!! Изменения могут быть тут
//        FirstClass firstClass;   // абстрактный токо поле потом реализуем ниже
//        SecondClass secondClass;
//        public void someAction() {
//            secondClass = new SecondClass();  // простой ту тновый екземпляр
//            if (param > 0){
//                firstClass = new FirstClass() {    // тут создали новый обьект
//                    @Override
//                    public Action getDependantAction() {   // переопределяем класс
//                        while (param > 0) System.out.println(param--);
//                        super.someAction();             // возвращаем родительский сомекшн
//
//                        return new Action() {
//                            @Override
//                            public void someAction() {
//
//                            }
//                        };
//                    }
//                };
//                firstClass.getDependantAction();   // тут вызываем метод который више переопределили по сути он после ифа
//            }
//                secondClass.someAction();      // и потом еще у секонд класа сомекшн
//            System.out.println(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.replaceAll("\n", "") + param);
//
//        }
//    };
//
//
//    public Solution(int param) {
//        this.param = param;
//    }
//
//    @Override
//    public void someAction() {
//        solutionAction.someAction();
//    }
//
//    /**
//     * 5
//     * 4
//     * 3
//     * 2
//     * 1
//     * class FirstClass, method someAction
//     * class SecondClass, method someAction
//     * Specific action for anonymous SecondClass, param = 0
//     * Count of created Action objects is 2
//     * class SecondClass, method someAction
//     * Specific action for anonymous SecondClass, param = -1
//     * Count of created Action objects is 3
//     */
//    public static void main(String[] args) {
//        Solution solution = new Solution(5);
//        solution.someAction();
//        System.out.println("Count of created Action objects is " + countActionObjects);
//
//        solution = new Solution(-1);
//        solution.someAction();
//        System.out.println("Count of created Action objects is " + countActionObjects);
//    }
//}

public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //!!!!! Changes can be here
        //!!!!! Изменения могут быть тут

        public void someAction() {
            //!!!!! All changes have to be here
            //!!!!! Все изменения должны быть только тут
            if (param > 0){
                while (param > 0) {
                    System.out.println(param--);
                }
                new FirstClass() {
                    @Override
                    public Action getDependantAction() {
                        super.someAction();
                        return null;

                    }
                }.someAction();
            }
            new SecondClass(){
                @Override
                public void someAction() {
                    System.out.println(sb.append(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM).append(param).toString());
                }
            }.someAction();
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}

package com.javarush.task.task25.task2505;

/*
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey){
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(false);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }



        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                try{
                    Thread.sleep(500);}
                catch (InterruptedException e){ }
                System.out.println(String.format("%s, %s, %s", MyThread.this.secretKey, thread.getName(), throwable.getMessage()));

                }

        }
    }

}

//

//package com.javarush.task.task25.task2505;
//
///*
//Без дураков
//*/
//public class Solution {
//
//    public static void main(String[] args) {
//        MyThread myThread = new Solution().new MyThread("super secret key");
//        myThread.start();
//    }
//
//    public class MyThread extends Thread{
//        private String secretKey;
//
//        public MyThread(String secretKey) {
//            this.secretKey = secretKey;
//            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//            setDaemon(false);
//        }
//
//        @Override
//        public void run() {
//            throw new NullPointerException("it's an example");
//        }
//        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
//
//
//
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                try {
//
//                    Thread.sleep(500);
//                } catch (InterruptedException ex) {
//
//                }
//
//                System.out.println(String.format("%s, %s, %s",((MyThread) t).secretKey, t.getName(), e.getMessage()));
//            }
//        }
//
//    }
//
//
//}






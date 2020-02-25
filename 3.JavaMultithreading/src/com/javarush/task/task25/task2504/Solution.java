package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
      for (Thread thread : threads) {
          switch (thread.getState()){
              case NEW:thread.start();break;
              case WAITING:thread.interrupt();break;
              case TIMED_WAITING:thread.interrupt();break;
              case RUNNABLE:thread.isInterrupted();break;
              case BLOCKED:thread.interrupt();break;
              case TERMINATED:
                  System.out.println(thread.getPriority());

          }
      }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
//        Thread[] threads = new Thread[4];
//        System.out.println("Start");
//        for (int i = 0; i < 4; i++) {
//            threads[i] = new JThread("JThread " + i);
//        }
//        processThreads(threads);
//    }
//}
//
//
//class JThread extends Thread {
//    JThread(String name) {
//        super(name);
//    }
//    @Override
//    public void run() {
//        System.out.println("Thread " + Thread.currentThread().getName());
    }
}
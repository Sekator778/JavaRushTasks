package com.javarush.task.task25.task2514;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            Thread.yield();
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
//        Thread thread = new Thread(() ->{
//            for (int i = 0; i < 3; i++) {
//                new Solution.YieldRunnable(i).run();
//            }
//        });
//       thread.start();
//        for (int i = 0; i < 3; i++) {
//            System.out.println("2 thread");
//            new Solution.YieldRunnable(i).run();
//        }
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++) {
            service.execute(new YieldRunnable(i));
        }
        service.shutdown();

    }
}

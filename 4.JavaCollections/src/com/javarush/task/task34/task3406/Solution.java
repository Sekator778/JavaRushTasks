package com.javarush.task.task34.task3406;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* 
Слабые ссылки
*/

public class Solution {
    public static Helper helper = new Helper();

    public static class Monkey {
        private final String name;

        public Monkey(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() {
            Helper.isFinalized = true;
            System.out.format("Bye-Bye, %s!\n", name);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // засечка времени
        helper.startTime();
        // крейт обьєкт
        Monkey monkey = new Monkey("Simka");
        // крейт вейкреференс link
        WeakReference<Monkey> weakReference = new WeakReference<>(monkey);

        //Add reference here
        // start gc and wait 1s
        helper.callGC();
        monkey = null;
        // start gc and wait 1s
        helper.callGC();
        //
        helper.consumeHeap();

        if (weakReference.get() == null)
            System.out.println("Finalized");

        helper.finish();
    }

    public static class Helper {
        public static boolean isFinalized;

        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.gc();
            Thread.sleep(1000);
        }

        void consumeHeap() {
            try {
                List<Solution> heap = new ArrayList<Solution>(100000);
                System.out.printf("consumeHeap");
                while (!isFinalized) {
                    System.out.printf("addSolution");
                    heap.add(new Solution());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("An out-of-memory exception has occurred");
            }
        }

        public void finish() {
            System.out.println("Done");
            System.out.println("It took " + getTime() + " s");
        }
    }
}

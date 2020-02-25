package com.javarush.task.task27.task2705;

/* 
Второй вариант deadlock
*/
public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {  // тут порядок блокирвки  иде 1 this
        synchronized (lock) {           // тут идет 2 lock
            doSomething();
        }
    }

    public void secondMethod() throws InterruptedException {
        synchronized(lock){
            Thread.sleep(100);// lock
            synchronized (this){        // this
                doSomething();
            }
       }
    }

    private void doSomething() {
        System.out.println("hi" + this.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                solution.firstMethod();
            }
        }).start();
//        Solution solution1 = new Solution();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    solution.secondMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
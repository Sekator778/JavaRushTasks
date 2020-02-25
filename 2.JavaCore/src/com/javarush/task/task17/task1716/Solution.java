package com.javarush.task.task17.task1716;

/* 
Синхронизированные методы
*/

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Solution implements Runnable{
    private double param = Math.random();
    private StringBuilder sb = new StringBuilder();

    private void method0() {
        Double d = method3();
    }

    protected void method1(String param1) {
        Solution solution = new Solution();
        solution.method0();
    }

    public void method2(int param1) {
        param1++;
    }

     synchronized double method3() {
        double random = Math.random();
        param += 40.7;
        return random + param;
    }

    private synchronized void method4() {
        sb.append(1).append(1).append(1).append(1);
    }

    protected void method5(String param2) {
        new StringBuffer().append(param2).append(param2).append(param2);
    }

    public synchronized String method6(int param2) {
        System.out.println("Thinking....");
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }

    String method7(double param2) {
        return "" + param2;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 5; i++) {
            service.submit(new Solution());

        }
        service.shutdown();

        service.awaitTermination(1, TimeUnit.HOURS);

    }

    @Override
    public void run() {
        Solution sol = new Solution();
        sol.method0();
        sol.method4();
        sol.method5("Lol");
        sol.method6(47);



    }
}

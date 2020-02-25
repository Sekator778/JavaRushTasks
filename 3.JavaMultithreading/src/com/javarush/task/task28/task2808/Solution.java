package com.javarush.task.task28.task2808;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/* 
Осваиваем Callable
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<>();
        long before = new Date().getTime();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1000; i <= 1010; i++) {
            futures.add(executor.submit(getTask(i)));
        }

        futures.add(executor.submit(getTask(10000000)));

        for(Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        long after = new Date().getTime();
        System.out.println("Time - " + (after - before) + " mS");


/* output
500500
501501
502503
503506
504510
505515
506521
507528
508536
509545
510555
50000005000000
*/
    }

    public static Callable<String> getTask(final int i) {
//        return ()-> {
//            long sum = 0;
//            for (int x = 0; x <= i; x++){
//                sum += x;
//            }return sum + " ";
//        };

        return ()-> (((long)i*(i+1))/2+"");
    }
}

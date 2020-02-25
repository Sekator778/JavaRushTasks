package Synchro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Test1 {
    private static int count = 0;
    private static ReentrantLock lock = new ReentrantLock();

    private static void increment() {
        lock.lock();
        try {
            count = count + 1;

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(Test1::increment));

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println(count);  // 9965
    }
}

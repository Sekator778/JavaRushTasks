import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FutureR {


    public static void main(String[] args) throws Exception {
        Callable task = () -> {
            return "Hello, World!";
        };
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        System.out.println(future.getClass());
        System.out.println(future.toString());
        System.out.println(future.get());
        System.out.println(future.toString());
        System.out.println(future.get());

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "String";
            }
        };
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Function<String, Integer> converter = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };
        Supplier<String> supplier1 = () -> "String";
        Consumer<String> consumer1 = s -> System.out.println(s);
        Function<String, Integer> converter1 = s -> Integer.valueOf(s);

        Semaphore semaphore = new Semaphore(0);
        Runnable task2 = () -> {
            try {
                semaphore.acquire();
                System.out.println("Finished");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task2).start();
        Thread.sleep(5000);
        System.out.println("wait wait permit a ?");
        semaphore.release(1);

        System.out.println("=====CountDownLatch=================");
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Runnable task3 = () -> {
            try {
                countDownLatch.countDown();
                System.out.println("Countdown: " + countDownLatch.getCount());
                countDownLatch.await();
                System.out.println("Finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(task3).start();
        }
        Thread.sleep(500);
        System.out.println("===CyclicBarrier=========");
        Runnable action = () -> System.out.println("На старт!");
        CyclicBarrier berrier = new CyclicBarrier(3, action);
        Runnable task4 = () -> {
            try {
                berrier.await();
                System.out.println("Finished");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        };
        System.out.println("Limit: " + berrier.getParties());
        for (int i = 0; i < 3; i++) {
            new Thread(task4).start();
        }
        Thread.sleep(500);
        System.out.println("===Exchanger=========");
        Exchanger<String> exchanger = new Exchanger<>();
        Runnable task5 = () -> {
            try {
                Thread thread = Thread.currentThread();
                String withThreadName = exchanger.exchange(thread.getName());
                System.out.println(thread.getName() + " обменялся с " + withThreadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task5).start();
        new Thread(task5).start();
    }



}
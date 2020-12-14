package producer_consumer.delayqueue;

import java.util.concurrent.*;

public class TestDelayQueue {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        BlockingQueue<DelayObject> queue = new DelayQueue<>();
        int numberOfElementsToProduce = 2;
        int delayOfEachProducedMessageMilliseconds = 500;
        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);
        DelayQueueProducer producer = new DelayQueueProducer(
                queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);

        // when
        executor.submit(producer);
        executor.submit(consumer);

        // then
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();

        System.out.println(consumer.numberOfConsumedElements.get());
        System.out.println(numberOfElementsToProduce);
    }
}

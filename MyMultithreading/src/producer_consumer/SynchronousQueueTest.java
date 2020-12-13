package producer_consumer;

import java.util.concurrent.*;

/**
 * A program tests for producer-consumer using SynchronousQueue
 *
 */
public class SynchronousQueueTest {
    static final int NUMBER_OF_CONSUMERS = 10;

    public static void main(String[] args) {

        BlockingQueue<Integer> syncQueue = new SynchronousQueue<>();

        Producer producer = new Producer(syncQueue);
        producer.start();

        Consumer[] consumers = new Consumer[NUMBER_OF_CONSUMERS];

        for (int i = 0; i < NUMBER_OF_CONSUMERS; i++) {
            consumers[i] = new Consumer(syncQueue);
            consumers[i].start();
        }
    }
}
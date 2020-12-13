package producer_consumer;

import java.util.concurrent.*;

/**
 * A consumer that takes elements from a BlockingQueue
 *
 */
public class Consumer extends Thread {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {

                Integer number = queue.take();
                consume(number);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private void consume(Integer number) {
        String message = "Consumer [" + getName() + "]: ";
        message += " processed number: " + number;
        System.out.println(message);
    }
}
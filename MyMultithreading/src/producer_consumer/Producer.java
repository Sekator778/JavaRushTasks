package producer_consumer;

import java.util.*;
import java.util.concurrent.*;

/**
 * A producer that puts elements to a BlockingQueue
 *
 */
public class Producer extends Thread {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {

                queue.put(produce());

            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private Integer produce() {
        Random randomer = new Random();
        Integer number = randomer.nextInt(1000);

        try {
            Thread.sleep(randomer.nextInt(2000));
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Producer: created number: " + number);

        return number;
    }
}
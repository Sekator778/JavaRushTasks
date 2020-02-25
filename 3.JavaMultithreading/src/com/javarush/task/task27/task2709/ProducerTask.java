package com.javarush.task.task27.task2709;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;
    static volatile AtomicInteger i = new AtomicInteger(0);

    public ProducerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ProducerTask").start();
    }

    public void run() {
        while (!stopped) {
            synchronized (transferObject){

                try {
                    transferObject.put(i.incrementAndGet());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}

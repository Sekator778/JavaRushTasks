package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;
    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()){
                System.out.println(Thread.currentThread().getName());

                Thread.sleep(100);}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();

    }

    @Override
    public void stop() {
        thread.interrupt();

    }
}
//4. Метод start должен создавать, сохранять во внутреннее поле и запускать нить с именем, которое передано через аргумент метода.
//5. Метод stop должен прерывать последнюю созданную классом TaskManipulator нить.

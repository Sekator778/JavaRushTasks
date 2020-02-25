package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
    //В классе Solution создай публичный статический класс AmigoThreadFactory, реализующий интерфейс ThreadFactory.
    //1. Реализация интерфейсного метода - создайте и верните трэд, который должен:
    //1.1. не быть демоном,
    //1.2. иметь нормальный приоритет,
    //1.3. имя трэда должно иметь шаблон "GN-pool-A-thread-B",
    //где GN - это имя группы,
    //A - это номер фабрики инкрементируется в пределах класса начиная с 1, используйте AtomicInteger,
    //B - номер треда инкрементируется в пределах конкретной фабрики начиная с 1, используйте AtomicInteger.
    //2. Каждая фабрика должна иметь ту группу тредов (ThreadGroup), в которой она была создана.
    //3. Методы main и emulateThreadFactory не участвуют в тестировании.
    public static class AmigoThreadFactory implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        public AmigoThreadFactory() {
            SecurityManager securityManager = System.getSecurityManager();
            group = (securityManager != null)? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = group.getName() + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(group, runnable, namePrefix + threadNumber.getAndIncrement(), 0);
            if (thread.isDaemon()){
                thread.setDaemon(false);
            }if (thread.getPriority() != Thread.NORM_PRIORITY){
                thread.setPriority(Thread.NORM_PRIORITY);
            }return thread;
        }
    }
}

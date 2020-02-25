import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

public class Synchon implements Runnable{
    private static Lock lock;

    public static void main(String[] args) {
        Synchon s1 = new Synchon();
        Synchon s2 = new Synchon();
//        Thread thread = new Thread(s1);
//        Thread thread1 = new Thread(s1);
//        thread.start();
//        thread1.start();
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(s1);
        service.submit(s2);
        service.shutdown();


    }

    public void F() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("i am F not synchro");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(300);

        }
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());

                System.out.println(" i am synchro block");
                Thread.sleep(300);
            }
        }
    }

    @Override
    public void run() {
        try {
            F();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

public class Join {

    public static void main(String[] args) throws InterruptedException {

       Thread thread = new Thread(new ThJoin());
       thread.start();
       thread.join();
        System.out.println("start main");



    }
}
class ThJoin implements Runnable {
    @Override
    public void run() {
        System.out.println("start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }
}

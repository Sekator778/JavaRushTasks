import java.io.IOException;
import java.util.concurrent.*;

public class ThreadSimple {


    public static class ThreadSample extends Thread {
        @Override
        public void run() {
            System.out.println("do some multithreaded task");
        }

        public static void main(String[] args) {
            ThreadSample ts2 = new ThreadSample();
            ts2.start();
        }
    }
    //Использование интерфейса Runnable основывается на другой парадигме.
    // Сначала программист должен реализовать интерфейс Runnable в собственном классе,
    // а затем поместить объект этого класса в объект типа Thread.
    // Интересующая функциональность также помещается в метод run класса,
    // реализующего интерфейс Runnable, и впоследствии вызывается объектом-контейнером,
    // как показано в листинге 2.
    //
    //Листинг 2. Запуск задач с помощью интерфейса java.lang.Runnable


     public static class RunnableSample implements Runnable {  // тут класс реализовывает интерфейс ранейбл
         public void run() {                                        // тут ран чтото мутит что хочем делать в многопоточке
             System.out.println("do some multithreaded task 2");  // вот это%)
       }
        public static void main(String[] args) {
        RunnableSample rs1 = new RunnableSample();  // создаем клас ранейбла типа
           Thread t1 = new Thread(rs1);             // кидаем впоток тот екземпляр ранейбл реализующего класса
           t1.start();              //запускаем
       }
     }


 public static class CallableSample implements Callable<String> {

     @Override
     public String call() throws Exception {
         return "Stringi";
     }
 }

 // **********************
 public static class ExecutorServiceSample {
     public static void main(String[] args) {
                  //создать ExecutorService на базе пула из пяти потоков
                  ExecutorService es1 = Executors.newFixedThreadPool(5);
                  //поместить задачу в очередь на выполнение
                  Future<String> f1 = es1.submit(new CallableSample());
                  while(!f1.isDone()) {
                          //подождать пока задача не выполнится
                      }
                 try {
                         //получить результат выполнения задачи
                         System.out.println("task has been completed : " + f1.get());
                     } catch (InterruptedException ie) {
                         ie.printStackTrace(System.err);
                     } catch (ExecutionException ee) {
                         ee.printStackTrace(System.err);
                     }
                 es1.shutdown();
             }
}




}

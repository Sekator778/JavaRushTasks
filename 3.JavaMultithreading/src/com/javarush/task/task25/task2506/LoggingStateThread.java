package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;
    private Thread.State state, lastState;

    public LoggingStateThread(Thread thread) {  // конструктор сюда ловим нить статус нити
        this.thread = thread;
        state = thread.getState();

    }

    @Override
    public void run() {
        State state, lastState = null;  // на всяк обнуляем
        do {
            state = thread.getState();   // поехали получаем статус нити
            if (state != lastState){  //если не нулл и сменила статус
                System.out.println(state);  //принт ее
                lastState = state;       // что принтанули записываем в ласт
            }
        }while (state != State.TERMINATED);  // делаем пока не завершиласт нить

    }
}

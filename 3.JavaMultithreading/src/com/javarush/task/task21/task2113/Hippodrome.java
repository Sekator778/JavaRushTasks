package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;
//Ипподром(6)
//Теперь перейдем к классу Hippodrome и методу main.
//Нам нужно создать объект
public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);

        }
    }

    public void move() {
        horses.get(0).move();
        horses.get(1).move();
        horses.get(2).move();

    }

    public void print() {
        for (Horse h : horses){
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        if ((horses.get(0).distance > horses.get(1).distance)&&(horses.get(0).distance > horses.get(2).distance)){
        return horses.get(0); }
        if ((horses.get(1).distance > horses.get(2).distance)&&(horses.get(1).distance > horses.get(0).distance)){
            return horses.get(1); }
        else return horses.get(2);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        Horse papa = new Horse("Papa", 3, 0);
        Horse mama = new Horse("Mama", 3, 0);
        Horse dochka = new Horse("Dochka", 3, 0);
        game.getHorses().add(papa);
        game.getHorses().add(mama);
        game.getHorses().add(dochka);

        game.run();
        game.printWinner();




    }
}

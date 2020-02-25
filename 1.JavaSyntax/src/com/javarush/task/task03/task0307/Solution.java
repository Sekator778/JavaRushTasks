package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
       // Zerg
       Zerg z1 = new Zerg();
       z1.name = "z1";
       Zerg z2 = new Zerg();
       z2.name = "z2";
       Zerg z3 = new Zerg();
       z3.name = "z3";
       Zerg z4 = new Zerg();
       z4.name = "z4";
       Zerg z5 = new Zerg();
       z5.name = "z5";
       // Protoss
       Protoss p1 = new Protoss();
       p1.name = "p1";
       Protoss p2 = new Protoss();
       p2.name = "p2";
       Protoss p3 = new Protoss();
       p3.name = "p3";
       // Terran = 4
       Terran t1 = new Terran();
       t1.name = "t1";
       Terran t2 = new Terran();
       t2.name = "t2";
       Terran t3 = new Terran();
       t3.name = "t3";
       Terran t4 = new Terran();
       t4.name = "t4";
       //напишите тут ваш код

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}

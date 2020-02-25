package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
В классе B должен быть реализован приватный метод writeObject с одним параметром типа ObjectOutputStream.
*/
public class Solution implements Serializable {
    public static class A {
        public A() {
        }

        protected String nameA = "A";

        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {
        //        public B() {}
        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.nameA);
            objectOutputStream.writeObject(this.nameB);

        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            nameA = (String) objectInputStream.readObject();
            nameB = (String) objectInputStream.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}

package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(Integer n, int m, String value) {  //1
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(Integer n, Integer m, String value) { //2
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(short n, int m, String value) { //3
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(Integer n, short m, String value) { //4
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(double n, short m, String value) { //5
        System.out.println("Заполняем объектами String");
        printMatrix(m, (short) n, (Object) value);
    }
    public static void printMatrix(float n, float m, Object value) { //6
        System.out.println("Заполняем объектами String");
        printMatrix((float)m, (float)n, (Object) value);
    }
    public static void printMatrix(float n, int m, String value) {//7
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(Integer n, float m, String value) {//8
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
}

package com.javarush.task.task22.task2213;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int k = 0;
        int[][] matrix = new int[5][5];
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                matrix[y][x] = (k++);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(matrix[3][0]);
        System.out.println(matrix[0][3]);
    }
}

package com.javarush.task.task22.task2213;

public class Field {
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }

    public void print() {
    }


    public void removeFullLines() {
    }

    public Integer getValue(int x, int y) {
        return null;
    }

    public void setValue(int x, int y, int value) {
        matrix[y][x] = value;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}

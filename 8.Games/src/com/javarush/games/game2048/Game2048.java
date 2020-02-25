package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                gameField[i][j] = 0;
            }
        }
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber() {
        int randomX;
        int randomY;
        int random;
        while (true) {
            randomX = getRandomNumber(SIDE);
            randomY = getRandomNumber(SIDE);
            if (gameField[randomX][randomY] == 0) {
                break;
            }
        }
        random = getRandomNumber(10);
        if (random == 9) {
            gameField[randomX][randomY] = 4;
        } else gameField[randomX][randomY] = 2;

    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 0:
                return Color.WHITE;
            case 2:
                return Color.BLUE;
            case 4:
                return Color.VIOLET;
            case 8:
                return Color.GRAY;
            case 16:
                return Color.GREEN;
            case 32:
                return Color.BROWN;
            case 64:
                return Color.ORANGE;
            case 128:
                return Color.BURLYWOOD;
            case 256:
                return Color.BISQUE;
            case 512:
                return Color.CORAL;
            case 1024:
                return Color.FLORALWHITE;
            case 2048:
                return Color.GOLD;
        }
        return null;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color cellColor = getColorByValue(value);
        if (value != 0) {
            setCellValueEx(x, y, cellColor, String.valueOf(value));
        } else setCellValueEx(x, y, cellColor, "");
    }

    private boolean compressRow(int[] row) {
        boolean move = false;
        for (int i = 1; i < row.length; i++) {
            if (row[i] == 0) continue;
            if (row[i] != 0 && row[i - 1] == 0) {
                row[i - 1] = row[i];
                row[i] = 0;
                move = true;
                i = 0;
            }
        }
        return move;
    }
// Было (4, 4, 0, 0), стало (8, 0, 0, 0). Метод вернул true.
//- Было (2, 2, 2, 2), стало (4, 0, 4, 0). Метод вернул true.
//- Было (4, 2, 2, 0), стало (4, 4, 0, 0). Метод вернул true.
//- Было (0, 2, 2, 0), стало (0, 4, 0, 0). Метод вернул true.
//- Было (0, 2, 2, 2), стало (0, 4, 0, 2). Метод вернул true.
//- Было (4, 0, 4, 0), стало (4, 0, 4, 0). Метод вернул false.
    private boolean mergeRow(int[] row) {
        boolean move = false;
        for (int i = 0; i < row.length-1; i++) {
            if (i == 0) {
                if (row[0] == row[1] && row[2] == row[0] && row[3] == row[0] && row[0] != 0) {
                    row[0] = row[0] + row[1];
                    row[2] = row[2] + row[3];
                    row[1] = 0;
                    row[3] = 0;
                    move = true;
                    break;
                }
            }
            if (row[i] == row[i+1] && row[i]!=0){
                row[i] = row[i] + row[i+1];
                row[i+1] = 0;
                i++;
                move = true;
            }
        }
        return move;
    }
}

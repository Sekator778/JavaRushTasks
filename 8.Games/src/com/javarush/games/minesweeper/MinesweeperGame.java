package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;


public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped = false;
    private int countClosedTiles = SIDE * SIDE;
    private int score ;
    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void  restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(0);
        createGame();
    }


    public void onMouseLeftClick(int x, int y){
        if (isGameStopped){restart(); return;}
        openTile(x, y); }

        private void gameOver() {
            isGameStopped = true;
            showMessageDialog(Color.BEIGE, "GAME OVER", Color.BLACK, 33);
        }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }


    private void markTile(int x, int y) {
        if (!isGameStopped == true) {
            if (!gameField[x][y].isOpen) {
                if (!(countFlags == 0 && !gameField[x][y].isFlag)) {
                    if (gameField[x][y].isFlag) {
                        gameField[x][y].isFlag = false;
                        setCellValue(x, y, "");
                        setCellColor(x, y, Color.ORANGE);
                        countFlags++;
                    } else if (!gameField[x][y].isFlag) {
                        gameField[x][y].isFlag = true;
                        countFlags--;
                        setCellValue(x, y, FLAG);
                        setCellColor(x, y, Color.YELLOW);
                    }
                }
            }
        }
    }

    private void openTile(int x, int y){

        if (!(gameField[y][x].isOpen || gameField[y][x].isFlag || isGameStopped == true)){
        gameField[y][x].isOpen=true;
            countClosedTiles--;
           if (!gameField[y][x].isMine) {score += 5;
            setScore(score);}
        setCellColor(x,y, Color.GREEN);

        if(gameField[y][x].isMine){
            setCellValueEx(x, y, Color.RED, MINE); gameOver();
        }
        else {
            boolean notZero = gameField[y][x].countMineNeighbors!=0;
            if(notZero) { setCellNumber(x,y,gameField[y][x].countMineNeighbors);}
            else {
                List<GameObject> list = new ArrayList<>();
                setCellValue(x, y, "");
                list=getNeighbors(gameField[y][x]);
                for(int i=0; i<list.size();i++){
                    int x1 = list.get(i).x;
                    int y1 = list.get(i).y;
                    if(!list.get(i).isOpen){
                        openTile(x1, y1);

                    }
                }
            }
        }
        }
        if ((countClosedTiles == countMinesOnField) && (!isGameStopped)){
            win();
            return;
        }

            }

        private void win() { isGameStopped = true; showMessageDialog(Color.AZURE, " YOU WIN" , Color.CRIMSON, 33);}


    private void createGame() {

        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                setCellValue(y, x, "");
            }}



        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;

    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        List<GameObject> NeighborsCount = new ArrayList<>();
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
               if(!gameField[y][x].isMine){NeighborsCount = getNeighbors(gameField[y][x]);
                   for (GameObject gO : NeighborsCount)
                       if (gO.isMine)
                           gameField[y][x].countMineNeighbors++;}

            }
            }
    }
}
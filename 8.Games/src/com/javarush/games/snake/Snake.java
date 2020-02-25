package com.javarush.games.snake;
import com.javarush.engine.cell.*;
import java.util.ArrayList;
import java.util.List;


public class Snake {


    private Direction direction = Direction.LEFT;
    public boolean isAlive = true;
    public int x;
    public int y;
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();
    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        GameObject gameObject = new GameObject(x, y);
        GameObject gameObject1 = new GameObject(x + 1, y);
        GameObject gameObject2 = new GameObject(x + 2, y);
        snakeParts.add(gameObject);
        snakeParts.add(gameObject1);
        snakeParts.add(gameObject2);
    }

    public void setDirection(Direction direction)
    {
        switch (this.direction) {
            case LEFT:
            case RIGHT:
                if (snakeParts.get(0).x == snakeParts.get(1).x) return;
                break;
            case UP:
            case DOWN:
                if (snakeParts.get(0).y == snakeParts.get(1).y) return;
                break;
        }
        this.direction = direction;
    }
//    {
//        if (direction == Direction.LEFT && snakeParts.get(0).x == snakeParts.get(1).x) return;
//        if (direction == Direction.RIGHT && snakeParts.get(0).x == snakeParts.get(1).x) return;
//        if (direction == Direction.UP && snakeParts.get(0).y == snakeParts.get(1).y) return;
//        if (direction == Direction.DOWN && snakeParts.get(0).y == snakeParts.get(1).y) return;
//
//        this.direction = direction;
//    }

    public void move(Apple apple){
        GameObject headNew = createNewHead();
        if (checkCollision(headNew)){
            isAlive = false; return;
        } else {snakeParts.add(0, headNew); removeTail();}
        if (headNew.x == apple.x && headNew.y == apple.y) apple.isAlive = false;
        else removeTail();
    }

    public void draw (Game game) {
        Color s = null;
        if (isAlive) {s = Color.BLACK;}
        else {s = Color.RED;}
        for (int i = 0; i < snakeParts.size(); i++) {
            if (i == 0){
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, HEAD_SIGN, s, 75);
            }else {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y,  Color.NONE, BODY_SIGN, s, 75);}
        }
    }
    public GameObject createNewHead() {
        GameObject gameObject = null;
        switch (direction){
            case LEFT: gameObject = new GameObject(snakeParts.get(0).x-1, snakeParts.get(0).y);break;
            case RIGHT: gameObject = new GameObject(snakeParts.get(0).x+1, snakeParts.get(0).y);break;
            case UP: gameObject = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y-1);break;
            case DOWN: gameObject = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y+1);break;
        }

        return gameObject;
    }
    public void removeTail() {
        snakeParts.remove(snakeParts.size()-1);
    }

    public boolean checkCollision(GameObject gameObject) {
        for (GameObject g : snakeParts){
            if (g.x == gameObject.x && g.y == gameObject.y) return true;
        } return false;
    }

    public int getLength() {return snakeParts.size();}


}

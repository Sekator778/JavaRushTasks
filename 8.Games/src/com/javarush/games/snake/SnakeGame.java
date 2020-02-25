package com.javarush.games.snake;
import com.javarush.engine.cell.*;

public class SnakeGame extends Game{
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private int turnDelay;
    private Snake snake;
    private Apple apple;
    private boolean isGameStopped;
    private static final int GOAL = 28;
    private int score = 0;

    public void initialize(){               // размер экрана
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void createGame(){
        score = 0;
        Snake snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        isGameStopped = false;
        drawScene();
        this.snake = snake;
        turnDelay = 300;
        setTurnTimer(turnDelay);
        setScore(score);

    }
    private void  drawScene(){

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }
    public void onTurn(int x) {
        snake.move(apple);
        if (apple.isAlive == false) {createNewApple(); score += 5; setScore(score); turnDelay -= 10; setTurnTimer(turnDelay);}
        if (snake.isAlive == false) gameOver();
        if (snake.getLength() > GOAL)win();
        drawScene();

    }
//
//4. Метод onTurn(int) должен увеличивать значение поля score на 5, если яблоко "неживое".
//            5. Метод onTurn(int) должен вызвать метод setScore(int) с параметром score, если яблоко "неживое".
//            6. Метод onTurn(int) должен уменьшить значение поля turnDelay на 10, если яблоко "неживое".
//            7. Метод onTurn(int) должен вызвать метод setTurnTimer(int) с параметром turnDelay, если яблоко "неживое".


    @Override
    public void onKeyPress(Key key) {
        if (key.equals(Key.SPACE) && isGameStopped == true) {
            createGame();
        }
        switch (key) {
            case LEFT: snake.setDirection(Direction.LEFT);break;
            case RIGHT: snake.setDirection(Direction.RIGHT);break;
            case UP: snake.setDirection(Direction.UP);break;
            case DOWN: snake.setDirection(Direction.DOWN);break;

        }
    }
    private void createNewApple() {
        do {
            apple = new Apple(getRandomNumber(WIDTH),  getRandomNumber(HEIGHT));
        }
        while (snake.checkCollision(apple));
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.DARKGREY, "GAME OVER !!!", Color.LIME, 20);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.GOLD, "YOU WIN !!!", Color.MOCCASIN, 26);
    }


    //7. В методе onTurn(int) должен вызываться метод gameOver() перед методом drawScene(), если змея мертвая (isAlive == false).
}
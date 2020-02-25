package com.javarush.task.task35.task3513;

import java.util.Arrays;

public class Model {
    private static final int  FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        Arrays.stream(gameTiles).forEach(x -> Arrays.setAll(x, i -> new Tile())); //!!!!!!!!!!!!!!???????????
    }
}

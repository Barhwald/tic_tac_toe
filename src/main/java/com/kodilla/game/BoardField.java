package com.kodilla.game;

public class BoardField {

    private char value;
    private boolean isEmpty;
    private final int coordinateX;
    private final int coordinateY;

    public BoardField(int coordinateX, int coordinateY, char value, boolean isEmpty) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.value = value;
        this.isEmpty = isEmpty;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean state) {
        isEmpty = state;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }
}

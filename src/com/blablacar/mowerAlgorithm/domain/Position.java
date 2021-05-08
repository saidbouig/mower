package com.blablacar.mowerAlgorithm.domain;

public class Position {
    private int x;
    private int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(int x, int y){
        return new Position(x,y);
    }

    public void moveBy(Orientation orientation){
        switch (orientation) {
            case N -> incrementY();
            case E -> incrementX();
            case S -> decrementY();
            case W -> decrementX();
        }
    }

    public void incrementX(){
        x++;
    }

    public void decrementX() {
        x--;
    }

    public void incrementY(){
        y++;
    }

    public void decrementY() {
        y--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

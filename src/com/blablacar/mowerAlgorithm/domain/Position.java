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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveBy(Orientation orientation){
        switch (orientation) {
            case N : incrementY(); break;
            case E : incrementX(); break;
            case S : decrementY(); break;
            case W : decrementX(); break;
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
}

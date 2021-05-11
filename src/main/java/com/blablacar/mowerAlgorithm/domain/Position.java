package com.blablacar.mowerAlgorithm.domain;

public class Position {
    volatile private int x;
    volatile private int y;
    private LawnBoundary lawnBoundary;

    public LawnBoundary getLawnBoundary() {
        return lawnBoundary;
    }

    public void setLawnBoundary(LawnBoundary lawnBoundary) {
        this.lawnBoundary = lawnBoundary;
    }

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Position(int x, int y, LawnBoundary lawnBoundary) {
        this.x = x;
        this.y = y;
        this.lawnBoundary = lawnBoundary;
    }

    public static Position of(int x, int y){
        return new Position(x,y);
    }

    public static Position from(Position position){
        return new Position(
                position.getX(),
                position.getY(),
                position.getLawnBoundary()!= null ? LawnBoundary.from(position.getLawnBoundary()): null);
    }
    public void moveBy(Orientation orientation){
        switch (orientation) {
            case N : incrementY(); break;
            case E : incrementX(); break;
            case S : decrementY(); break;
            case W : decrementX(); break;
        }
    }

    public void incrementX() {
        x++;
    }

    public void decrementX() {
        x--;
    }

    public void incrementY() {
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


    public boolean isWithinLawnBoundaries() {
        return x>= lawnBoundary.getX_min()
                && x<lawnBoundary.getX_max()
                && y>= lawnBoundary.getY_min()
                && y< lawnBoundary.getY_max();
    }
}

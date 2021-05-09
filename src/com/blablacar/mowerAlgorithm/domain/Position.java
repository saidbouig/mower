package com.blablacar.mowerAlgorithm.domain;

public class Position {
    private int x;
    private int y;
    private int x_max_boundary = Integer.MAX_VALUE;
    private int y_max_boundary = Integer.MAX_VALUE;
    private int x_min_boundary = Integer.MIN_VALUE;
    private int y_min_boundary = Integer.MIN_VALUE;

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

    public void incrementX() {
        x = Math.min(x + 1, x_max_boundary);
    }

    public void decrementX() {
        x = Math.max(x - 1, x_min_boundary);
    }

    public void incrementY() {
        y = Math.min(y + 1, y_max_boundary);
    }

    public void decrementY() {
        y = Math.max(y - 1, y_min_boundary);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX_max_boundary(int x_max_boundary) {
        this.x_max_boundary = x_max_boundary;
    }

    public void setY_max_boundary(int y_max_boundary) {
        this.y_max_boundary = y_max_boundary;
    }

    public void setX_min_boundary(int x_min_boundary) {
        this.x_min_boundary = x_min_boundary;
    }

    public void setY_min_boundary(int y_min_boundary) {
        this.y_min_boundary = y_min_boundary;
    }
}

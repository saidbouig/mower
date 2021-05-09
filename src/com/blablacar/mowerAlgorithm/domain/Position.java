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

    public Position(int x, int y, int x_max_boundary, int y_max_boundary, int x_min_boundary, int y_min_boundary) {
        this.x = x;
        this.y = y;
        this.x_max_boundary = x_max_boundary;
        this.y_max_boundary = y_max_boundary;
        this.x_min_boundary = x_min_boundary;
        this.y_min_boundary = y_min_boundary;
    }

    public static Position of(int x, int y){
        return new Position(x,y);
    }

    public static Position from(Position position){
        return new Position(
                position.getX(),
                position.getY(),
                position.getX_max_boundary(),
                position.getY_max_boundary(),
                position.getX_min_boundary(),
                position.getY_min_boundary()
        );
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

    public int getX_max_boundary() {
        return x_max_boundary;
    }

    public int getY_max_boundary() {
        return y_max_boundary;
    }

    public int getX_min_boundary() {
        return x_min_boundary;
    }

    public int getY_min_boundary() {
        return y_min_boundary;
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

    public boolean isWithinLawnBoundaries() {
        return x>= x_min_boundary && x<x_max_boundary && y>= y_min_boundary && y< y_max_boundary;
    }
}

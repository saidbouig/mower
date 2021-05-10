package com.blablacar.mowerAlgorithm.domain;

public class LawnBoundary {
    private final int x_max_boundary;
    private final int y_max_boundary;
    private final int x_min_boundary;
    private final int y_min_boundary;

    private LawnBoundary(int x_max_boundary, int y_max_boundary, int x_min_boundary, int y_min_boundary) {
        this.x_max_boundary = x_max_boundary;
        this.y_max_boundary = y_max_boundary;
        this.x_min_boundary = x_min_boundary;
        this.y_min_boundary = y_min_boundary;
    }

    public static LawnBoundary of(int x_max_boundary, int y_max_boundary, int x_min_boundary, int y_min_boundary){
        return new LawnBoundary(x_max_boundary, y_max_boundary, x_min_boundary, y_min_boundary);
    }

    public static LawnBoundary from(LawnBoundary lawnBoundary) {
        return new LawnBoundary(lawnBoundary.x_max_boundary, lawnBoundary.y_max_boundary, lawnBoundary.x_min_boundary, lawnBoundary.y_min_boundary);
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
}

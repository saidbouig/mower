package com.blablacar.moweralgorithm.domain;

public class LawnBoundary {
    private final int x_max;
    private final int y_max;
    private final int x_min;
    private final int y_min;

    private LawnBoundary(int x_max, int y_max, int x_min, int y_min) {
        this.x_max = x_max;
        this.y_max = y_max;
        this.x_min = x_min;
        this.y_min = y_min;
    }

    public static LawnBoundary of(int x_max_boundary, int y_max_boundary) {
        return new LawnBoundary(x_max_boundary, y_max_boundary, 0, 0);
    }

    public static LawnBoundary from(LawnBoundary lawnBoundary) {
        return new LawnBoundary(lawnBoundary.x_max, lawnBoundary.y_max, lawnBoundary.x_min, lawnBoundary.y_min);
    }

    public int getX_max() {
        return x_max;
    }

    public int getY_max() {
        return y_max;
    }

    public int getX_min() {
        return x_min;
    }

    public int getY_min() {
        return y_min;
    }
}

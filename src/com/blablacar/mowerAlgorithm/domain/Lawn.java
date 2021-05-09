package com.blablacar.mowerAlgorithm.domain;

public class Lawn {
    private int width;
    private int height;

    private Lawn(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Lawn of(int width, int height){
        return new Lawn(width,height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

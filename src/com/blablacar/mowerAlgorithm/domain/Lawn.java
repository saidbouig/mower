package com.blablacar.mowerAlgorithm.domain;

public class Lawn {
    private int width;
    private int highth;

    private Lawn(int width, int highth) {
        this.width = width;
        this.highth = highth;
    }

    public static Lawn of(int width, int highth){
        return new Lawn(width,highth);
    }

    public int getWidth() {
        return width;
    }

    public int getHighth() {
        return highth;
    }
}

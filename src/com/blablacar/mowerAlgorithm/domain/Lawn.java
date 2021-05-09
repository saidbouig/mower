package com.blablacar.mowerAlgorithm.domain;

import java.util.List;

public class Lawn {
    private final int width;
    private final int height;
    private List<Mower> mowers;

    private Lawn(int width, int height, List<Mower> mowers) {
        this.width = width;
        this.height = height;
        this.mowers = mowers;
    }

    public static Lawn of(int width, int height, List<Mower> mowers){
        return new Lawn(width,height, mowers);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean authorizedToMove(Mower mower, Position previewPosition) {
        return mowers.stream().map(Mower::getPosition)
                .filter(m -> ! (m.getX() == mower.getPosition().getX() && m.getY() == mower.getPosition().getY()))
                .noneMatch(m -> m.getX() == previewPosition.getX() && m.getY() == previewPosition.getY());
    }
}

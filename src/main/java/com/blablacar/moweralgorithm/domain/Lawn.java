package com.blablacar.moweralgorithm.domain;

import java.util.List;

public class Lawn implements ILawn {
    private final int width;
    private final int height;
    private List<Mower> mowers;

    private Lawn(int width, int height, List<Mower> mowers) {
        this.width = width;
        this.height = height;
        this.mowers = mowers;
    }

    public static Lawn of(int width, int height){
        return new Lawn(width,height, null);
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

    @Override
    public boolean isAuthorizedToMove(Mower mower, Position previewPosition) {
        return mowers.stream().map(Mower::getPosition)
                .filter(m -> ! (m.getX() == mower.getPosition().getX() && m.getY() == mower.getPosition().getY()))
                .noneMatch(m -> m.getX() == previewPosition.getX() && m.getY() == previewPosition.getY());
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }
}
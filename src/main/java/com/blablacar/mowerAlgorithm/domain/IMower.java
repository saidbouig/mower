package com.blablacar.mowerAlgorithm.domain;

public interface IMower {
    void applyBoundariesFrom(Lawn lawn);

    void moveToForward(Lawn lawn);

    Position previewMoveToForward();

    void rotateToRight();

    void rotateToLeft();
}

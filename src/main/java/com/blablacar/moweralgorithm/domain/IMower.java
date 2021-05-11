package com.blablacar.moweralgorithm.domain;

public interface IMower {
    void applyBoundariesFrom(Lawn lawn);

    void moveToForward(Lawn lawn);

    Position previewMoveToForward();

    void rotateToRight();

    void rotateToLeft();
}

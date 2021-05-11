package com.blablacar.moweralgorithm.domain;

@FunctionalInterface
public interface ILawn {
    boolean isAuthorizedToMove(Mower mower, Position previewPosition);
}

package com.blablacar.moweralgorithm.domain;

public interface ILawn {
    boolean isAuthorizedToMove(Mower mower, Position previewPosition);
}

package com.blablacar.mowerAlgorithm.domain;

public interface ILawn {
    boolean isAuthorizedToMove(Mower mower, Position previewPosition);
}

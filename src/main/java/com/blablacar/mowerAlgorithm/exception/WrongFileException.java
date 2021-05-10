package com.blablacar.mowerAlgorithm.exception;

public class WrongFileException extends RuntimeException {
    public WrongFileException(final String errorMessage) {
        super(errorMessage);
    }
}

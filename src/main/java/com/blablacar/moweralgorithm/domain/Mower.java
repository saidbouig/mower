package com.blablacar.moweralgorithm.domain;

import java.util.Objects;

public class Mower implements IMower {
    private Position position;
    private Orientation orientation;

    private Mower(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public static Mower of(Position position, Orientation orientation) {
        return new Mower(position, orientation);
    }

    @Override
    public void moveToForward(Lawn lawn) {
        Position previewPosition = calculateNextPosition();
        if (lawn.isAuthorizedToMove(this, previewPosition)) {
            position = previewPosition;
        }
    }

    @Override
    public Position calculateNextPosition() {
        Position previewPosition = Position.from(position);
        previewPosition.moveBy(orientation);
        return previewPosition;
    }

    @Override
    public void rotateToRight() {
        switch (orientation) {
            case N:
                orientation = Orientation.E;
                break;
            case E:
                orientation = Orientation.S;
                break;
            case S:
                orientation = Orientation.W;
                break;
            case W:
                orientation = Orientation.N;
                break;
        }
    }

    @Override
    public void rotateToLeft() {
        switch (orientation) {
            case N:
                orientation = Orientation.W;
                break;
            case W:
                orientation = Orientation.S;
                break;
            case S:
                orientation = Orientation.E;
                break;
            case E:
                orientation = Orientation.N;
                break;
        }
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + orientation.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(position, mower.position) &&
                orientation == mower.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }
}

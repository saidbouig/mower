package com.blablacar.mowerAlgorithm.domain;

public class Mower {
    private Position position;
    private Orientation orientation;

    private Mower(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public static Mower of(Position position, Orientation orientation){
        return new Mower(position, orientation);
    }

    public void applyBoundariesFrom(Lawn lawn){
        position.setX_max_boundary(lawn.getWidth());
        position.setY_max_boundary(lawn.getHighth());
        position.setX_min_boundary(0);
        position.setY_min_boundary(0);
    }

    public void moveToForward(){
        position.moveBy(orientation);
    }

    public void rotateToRight(){
        switch (orientation){
            case N -> orientation = Orientation.E;
            case E -> orientation = Orientation.S;
            case S -> orientation = Orientation.W;
            case W -> orientation = Orientation.N;
        }
    }
    public void rotateToLeft(){
        switch (orientation){
            case N -> orientation = Orientation.W;
            case W -> orientation = Orientation.S;
            case S -> orientation = Orientation.E;
            case E -> orientation = Orientation.N;
        }
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}

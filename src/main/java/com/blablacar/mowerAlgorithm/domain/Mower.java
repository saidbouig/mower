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
        position.setLawnBoundary(LawnBoundary.of(lawn.getWidth(), lawn.getHeight()));
    }

    public void moveToForward(Lawn lawn){
        if(position.getLawnBoundary()!=null){
            Position previewPosition = previewMoveToForward();
            if(previewPosition.isWithinLawnBoundaries() && lawn.authorizedToMove(this, previewPosition)){
                this.position = previewPosition;
            }
        }else{
            position.moveBy(orientation);
        }
    }

    public Position previewMoveToForward(){
        Position previewPosition = Position.from(position);
        previewPosition.moveBy(orientation);
        return previewPosition;
    }

    public void rotateToRight(){
        switch (orientation){
            case N : orientation = Orientation.E; break;
            case E : orientation = Orientation.S; break;
            case S : orientation = Orientation.W; break;
            case W : orientation = Orientation.N; break;
        }
    }
    public void rotateToLeft(){
        switch (orientation){
            case N : orientation = Orientation.W; break;
            case W : orientation = Orientation.S; break;
            case S : orientation = Orientation.E; break;
            case E : orientation = Orientation.N; break;
        }
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}

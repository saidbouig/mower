package com.blablacar.moweralgorithm.domain;

public class Mower implements IMower {
    private Position position;
    private Orientation orientation;

    private Mower(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public static Mower of(Position position, Orientation orientation){
        return new Mower(position, orientation);
    }

    @Override
    public void applyBoundariesFrom(Lawn lawn){
        position.setLawnBoundary(LawnBoundary.of(lawn.getWidth(), lawn.getHeight()));
    }

    @Override
    public void moveToForward(Lawn lawn){
        if(position.getLawnBoundary()!=null){
            Position previewPosition = previewMoveToForward();
            if(previewPosition.isWithinLawnBoundaries() && lawn.isAuthorizedToMove(this, previewPosition)){
                position = previewPosition;
            }
        }else{
            position.moveBy(orientation);
        }
    }

    @Override
    public Position previewMoveToForward(){
        Position previewPosition = Position.from(position);
        previewPosition.moveBy(orientation);
        return previewPosition;
    }

    @Override
    public void rotateToRight(){
        switch (orientation){
            case N : orientation = Orientation.E; break;
            case E : orientation = Orientation.S; break;
            case S : orientation = Orientation.W; break;
            case W : orientation = Orientation.N; break;
        }
    }
    @Override
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

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + orientation.name();
    }
}

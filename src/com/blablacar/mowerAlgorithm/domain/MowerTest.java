package com.blablacar.mowerAlgorithm.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerTest {

    @Test
    void should_create_mower_from_position_and_orientation() {
        Mower mower = Mower.of(Position.of(10,20),Orientation.N);
        assertEquals(mower.getPosition().getX(), 10);
        assertEquals(mower.getPosition().getY(), 20);
        assertEquals(mower.getOrientation(), Orientation.N);
    }

    @Test
    void should_move_mower_forward() {
        Mower mower = Mower.of(Position.of(0,0),Orientation.S);
        mower.moveToForward();
        assertEquals(mower.getPosition().getX(), 0);
        assertEquals(mower.getPosition().getY(), -1);
        assertEquals(mower.getOrientation(), Orientation.S);
    }

    @Test
    void should_rotate_mower_to_the_right() {
        Mower mower = Mower.of(Position.of(0,0),Orientation.S);
        mower.rotateToRight();
        assertEquals(mower.getPosition().getX(), 0);
        assertEquals(mower.getPosition().getY(), 0);
        assertEquals(mower.getOrientation(), Orientation.W);
    }

    @Test
    void should_rotate_mower_to_the_left() {
        Mower mower = Mower.of(Position.of(0,0),Orientation.S);
        mower.rotateToLeft();
        assertEquals(mower.getPosition().getX(), 0);
        assertEquals(mower.getPosition().getY(), 0);
        assertEquals(mower.getOrientation(), Orientation.E);
    }

    @Test
    void should_stay_idle_when_move_to_lawn_boundary(){
        Mower mower = Mower.of(Position.of(0,0),Orientation.S);
        Lawn lawn = Lawn.of(2,2);
        mower.applyBoundariesFrom(lawn);
        mower.moveToForward();
        mower.moveToForward();
        mower.moveToForward();
        assertEquals(mower.getPosition().getX(), 0);
        assertEquals(mower.getPosition().getY(), 0);
        assertEquals(mower.getOrientation(), Orientation.S);
    }

}

package com.blablacar.mowerAlgorithm.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
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
        Lawn lawn = Lawn.of(10,10,Collections.singletonList(mower));
        mower.moveToForward(lawn);
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
    void should_stay_idle_when_move_forward_to_lawn_boundary(){
        Mower mower = Mower.of(Position.of(0,0),Orientation.S);
        Lawn lawn = Lawn.of(2,2, Collections.singletonList(mower));
        mower.applyBoundariesFrom(lawn);
        mower.moveToForward(lawn);
        mower.moveToForward(lawn);
        mower.moveToForward(lawn);
        assertEquals(mower.getPosition().getX(), 0);
        assertEquals(mower.getPosition().getY(), 0);
        assertEquals(mower.getOrientation(), Orientation.S);
    }

    @Test
    void should_stay_idle_when_move_forward_to_an_other_mower(){
        Mower mower_1 = Mower.of(Position.of(0,0),Orientation.N);
        Mower mower_2 = Mower.of(Position.of(0,1),Orientation.N);

        Lawn lawn = Lawn.of(2,2, asList(mower_1, mower_2));

        mower_1.applyBoundariesFrom(lawn);
        mower_2.applyBoundariesFrom(lawn);

        mower_1.moveToForward(lawn);

        assertEquals(mower_1.getPosition().getX(), 0);
        assertEquals(mower_1.getPosition().getY(), 0);
        assertEquals(mower_1.getOrientation(), Orientation.N);

        assertEquals(mower_2.getPosition().getX(), 0);
        assertEquals(mower_2.getPosition().getY(), 1);
        assertEquals(mower_2.getOrientation(), Orientation.N);

    }

}

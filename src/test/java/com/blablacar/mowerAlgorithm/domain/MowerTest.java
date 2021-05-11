package com.blablacar.mowerAlgorithm.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerTest {

    @Test
    void should_create_mower_from_position_and_orientation() {
        Mower mower = Mower.of(Position.of(10, 20), Orientation.N);

        assertEquals("N 10 20", mower.toString());
    }

    @Test
    void should_move_mower_forward() {
        Mower mower = Mower.of(Position.of(0, 0), Orientation.S);
        Lawn lawn = Lawn.of(10, 10, Collections.singletonList(mower));
        mower.moveToForward(lawn);

        assertEquals("S 0 -1", mower.toString());
    }

    @Test
    void should_rotate_mower_to_the_right() {
        Mower mower = Mower.of(Position.of(0, 0), Orientation.S);
        mower.rotateToRight();

        assertEquals("W 0 0", mower.toString());
    }

    @Test
    void should_rotate_mower_to_the_left() {
        Mower mower = Mower.of(Position.of(0, 0), Orientation.S);
        mower.rotateToLeft();

        assertEquals("E 0 0", mower.toString());
    }

    @Test
    void should_stay_idle_when_move_forward_to_lawn_boundary() {
        Mower mower = Mower.of(Position.of(0, 0), Orientation.S);
        Lawn lawn = Lawn.of(2, 2, Collections.singletonList(mower));
        mower.applyBoundariesFrom(lawn);
        mower.moveToForward(lawn);
        mower.moveToForward(lawn);
        mower.moveToForward(lawn);

        assertEquals("S 0 0", mower.toString());
    }

    @Test
    void should_stay_idle_when_move_forward_to_an_other_mower() {
        Mower mower_1 = Mower.of(Position.of(0, 0), Orientation.N);
        Mower mower_2 = Mower.of(Position.of(0, 1), Orientation.N);

        Lawn lawn = Lawn.of(2, 2, asList(mower_1, mower_2));

        mower_1.applyBoundariesFrom(lawn);
        mower_2.applyBoundariesFrom(lawn);

        mower_1.moveToForward(lawn);

        assertEquals("N 0 0", mower_1.toString());
        assertEquals("N 0 1", mower_2.toString());
    }

}

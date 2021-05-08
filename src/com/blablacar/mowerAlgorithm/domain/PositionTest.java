package com.blablacar.mowerAlgorithm.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PositionTest {
    @Test
    public void should_create_position_from_coordinates(){
        Position position = Position.of(10, 20);
        assertEquals(position.getX(), 10);
        assertEquals(position.getY(), 20);
    }

    @Test
    public void should_move_position_by_orientation(){
        Position position = Position.of(0,0);

        position.moveBy(Orientation.N);
        assertEquals(position.getX(),0);
        assertEquals(position.getY(),1);

        position.moveBy(Orientation.E);
        assertEquals(position.getX(),1);
        assertEquals(position.getY(),1);

        position.moveBy(Orientation.S);
        assertEquals(position.getX(),1);
        assertEquals(position.getY(),0);

        position.moveBy(Orientation.W);
        assertEquals(position.getX(),0);
        assertEquals(position.getY(),0);
    }

}

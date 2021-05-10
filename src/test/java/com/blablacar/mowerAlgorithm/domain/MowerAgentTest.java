package com.blablacar.mowerAlgorithm.domain;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerAgentTest {

    @Test
    public void should_execute_instructions() {

        Mower mower = Mower.of(Position.of(0, 0), Orientation.N);
        Lawn lawn = Lawn.of(2, 2, singletonList(mower));

        mower.applyBoundariesFrom(lawn);

        MowerAgent mowerAgent = MowerAgent.of(mower, lawn, asList(Instruction.F, Instruction.F));
        mowerAgent.runCommands();

        assertEquals(mowerAgent.getMower().getOrientation(), Orientation.N);
        assertEquals(mowerAgent.getMower().getPosition().getX(), 0);
        assertEquals(mowerAgent.getMower().getPosition().getY(), 1);


    }

}

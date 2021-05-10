package com.blablacar.mowerAlgorithm.domain;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    public void should_run_simulation_with_one_mower(){
        Mower mower = Mower.of(Position.of(0, 0), Orientation.N);
        Lawn lawn = Lawn.of(2, 2, singletonList(mower));

        mower.applyBoundariesFrom(lawn);

        MowerAgent mowerAgent = MowerAgent.of(mower, lawn, asList(Instruction.F, Instruction.F));
        Simulation simulation = Simulation.of(singletonList(mowerAgent));

        simulation.run();

        assertEquals(mowerAgent.getMower().getOrientation(), Orientation.N);
        assertEquals(mowerAgent.getMower().getPosition().getX(), 0);
        assertEquals(mowerAgent.getMower().getPosition().getY(), 1);
    }

    @Test
    public void should_run_simulation_with_multiple_mowers(){
        Mower mower_1 = Mower.of(Position.of(0,0), Orientation.N);
        Mower mower_2 = Mower.of(Position.of(0,1), Orientation.S);
        Mower mower_3 = Mower.of(Position.of(1,1), Orientation.S);

        Lawn lawn = Lawn.of(2,2, asList(mower_1, mower_2, mower_3));

        mower_1.applyBoundariesFrom(lawn);
        mower_2.applyBoundariesFrom(lawn);
        mower_3.applyBoundariesFrom(lawn);

        MowerAgent mowerAgent_1 = MowerAgent.of(mower_1,lawn,asList(Instruction.F, Instruction.F));
        MowerAgent mowerAgent_2 = MowerAgent.of(mower_2,lawn,asList(Instruction.F, Instruction.F));
        MowerAgent mowerAgent_3 = MowerAgent.of(mower_3,lawn,asList(Instruction.F, Instruction.F, Instruction.R,Instruction.F));
        Simulation simulation = Simulation.of(asList(mowerAgent_1, mowerAgent_2, mowerAgent_3));

        simulation.run();

        assertEquals(Orientation.N, mowerAgent_1.getMower().getOrientation());
        assertEquals(0, mowerAgent_1.getMower().getPosition().getX());
        assertEquals(0, mowerAgent_1.getMower().getPosition().getY());

        assertEquals(Orientation.S, mowerAgent_2.getMower().getOrientation());
        assertEquals(0, mowerAgent_2.getMower().getPosition().getX());
        assertEquals(1, mowerAgent_2.getMower().getPosition().getY());

        assertEquals(Orientation.W, mowerAgent_3.getMower().getOrientation());
        assertEquals(1, mowerAgent_3.getMower().getPosition().getX());
        assertEquals(0, mowerAgent_3.getMower().getPosition().getY());
    }

}

package com.blablacar.mowerAlgorithm.domain;

import com.blablacar.mowerAlgorithm.service.Instruction;
import com.blablacar.mowerAlgorithm.service.MowerAgent;
import com.blablacar.mowerAlgorithm.service.Simulation;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    public void should_run_simulation_with_one_mower() throws InterruptedException {
        Mower mower = Mower.of(Position.of(0, 0), Orientation.N);
        Lawn lawn = Lawn.of(2, 2, singletonList(mower));

        mower.applyBoundariesFrom(lawn);

        MowerAgent mowerAgent = MowerAgent.of(mower, lawn, asList(Instruction.F, Instruction.F));
        Simulation simulation = Simulation.of(singletonList(mowerAgent));

        simulation.run();

        assertEquals(mowerAgent.toString(), "N 0 1");
    }

    @Test
    public void should_run_simulation_with_multiple_mowers() throws InterruptedException {
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

        assertEquals(mowerAgent_1.toString(), "N 0 0");
        assertEquals(mowerAgent_2.toString(), "S 0 1");
        assertEquals(mowerAgent_3.toString(), "W 1 0");
    }

}

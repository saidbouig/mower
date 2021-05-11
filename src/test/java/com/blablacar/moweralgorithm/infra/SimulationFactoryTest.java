package com.blablacar.moweralgorithm.infra;

import com.blablacar.moweralgorithm.application.Simulation;
import com.blablacar.moweralgorithm.application.SimulationFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SimulationFactoryTest {
    @Test
    public void should_create_simulation(){
        List<String> lines = Arrays.asList("5 5", "1 2 N", "LFLFLFLFF","3 3 N", "LFLFLFLFF");

        Simulation simulation = SimulationFactory.create(lines);
        assertNotNull(simulation);
    }
}

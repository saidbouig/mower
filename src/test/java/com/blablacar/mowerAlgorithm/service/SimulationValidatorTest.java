package com.blablacar.mowerAlgorithm.service;

import com.blablacar.mowerAlgorithm.domain.Lawn;
import com.blablacar.mowerAlgorithm.exception.SimulationParserException;
import org.junit.jupiter.api.Test;

import static com.blablacar.mowerAlgorithm.service.SimulationValidator.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimulationValidatorTest {

    @Test
    public void should_throw_simulation_exception_when_invalid_lawn_coordinates() {
        String[] coordinates = { "0", "-41"};
        assertThrows(SimulationParserException.class, () -> validateLawn(coordinates));
    }

    @Test
    public void should_throw_simulation_exception_when_mower_position_out_of_lawn_boundaries() {
        String[] lines = { "20", "20", "N"};
        assertThrows(SimulationParserException.class, () -> validateMower(lines, Lawn.of(10,10)));
    }

    @Test
    public void should_throw_simulation_exception_when_mower_orientation_is_invalid() {
        String[] lines = { "0", "0", "C"};
        assertThrows(SimulationParserException.class, () -> validateMower(lines, Lawn.of(10,10)));
    }

    @Test
    public void should_throw_simulation_exception_when_instructions_are_invalid() {
        String[] lines = { "L", "L", "C"};
        assertThrows(SimulationParserException.class, () -> validateInstructions(lines));
    }

}

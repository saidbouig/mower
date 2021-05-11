package com.blablacar.moweralgorithm.infra;

import com.blablacar.moweralgorithm.application.Instruction;
import com.blablacar.moweralgorithm.domain.Lawn;
import com.blablacar.moweralgorithm.domain.Mower;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.blablacar.moweralgorithm.infra.SimulationParser.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulationParserTest {

    @Test
    public void should_parse_lawn(){
        Lawn lawn = Lawn.of(10,10);
        Lawn parsedlawn = parseLawn("10 10");
        assertEquals(parsedlawn.getWidth(), lawn.getWidth());
        assertEquals(parsedlawn.getHeight(), lawn.getHeight());
    }

    @Test
    public void should_parse_mower(){
        Lawn lawn = Lawn.of(10,10);

        Mower mower = parseMower("0 0 N", lawn);
        assertEquals("0 0 N" , mower.toString());
    }

    @Test
    public void should_parse_instructions(){
        List<Instruction> instructions = parseInstructions("LL");
        instructions.forEach(instruction -> assertEquals(instruction, Instruction.L));
    }

}

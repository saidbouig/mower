package com.blablacar.mowerAlgorithm.service;

import com.blablacar.mowerAlgorithm.domain.Lawn;
import com.blablacar.mowerAlgorithm.domain.Mower;
import com.blablacar.mowerAlgorithm.domain.Orientation;
import com.blablacar.mowerAlgorithm.domain.Position;
import com.blablacar.mowerAlgorithm.exception.SimulationParserException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimulationParser {

    public static List<Instruction> parseInstructions(String line) {
        String[] lines = line.split("");
        try{
            SimulationValidator.validateInstructions(lines);
            return Stream.of(lines)
                    .map(Instruction::valueOf)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new SimulationParserException(String.format("Error parsing Instructions : ", Arrays.toString(lines), e));
        }
    }

    public static Mower parseMower(String line, Lawn lawn) {
        String[] lines = line.split(" ");
        try {
            SimulationValidator.validateMower(lines, lawn);
            Mower mower = Mower.of(Position.of(Integer.parseInt(lines[0]), Integer.parseInt(lines[1])),
                    Orientation.valueOf(lines[2]));
            mower.applyBoundariesFrom(lawn);
            return mower;
        }catch (Exception e){
            throw new SimulationParserException(String.format("Error parsing Mower : ", Arrays.toString(lines), e));
        }
    }

    public static Lawn parseLawn(String line) {
        var coordinates = line.split(" ");
        try {
            SimulationValidator.validateLawn(coordinates);
            return Lawn.of(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        }catch (NumberFormatException e){
            throw new SimulationParserException(String.format("Error parsing Lawn : ", Arrays.toString(coordinates), e));
        }
    }
}

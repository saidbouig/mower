package com.blablacar.mowerAlgorithm.service;

import com.blablacar.mowerAlgorithm.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimulationParser {


    public static List<Instruction> parseInstructions(String line) {
        String[] lines = line.split("");
        return Stream.of(lines)
                .map(Instruction::valueOf)
                .collect(Collectors.toList());
    }

    public static Mower parseMower(String line, Lawn lawn) {
        String[] lines = line.split(" ");
        Mower mower = Mower.of(Position.of(Integer.parseInt(lines[0]), Integer.parseInt(lines[1])),
                Orientation.valueOf(lines[2]));
        mower.applyBoundariesFrom(lawn);
        return mower;
    }

    public static Lawn parseLawn(String line) {
        var coordinates = line.split(" ");
        return Lawn.of(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), Collections.emptyList());
    }
}

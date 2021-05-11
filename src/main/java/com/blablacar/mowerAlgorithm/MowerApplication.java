package com.blablacar.mowerAlgorithm;

import com.blablacar.mowerAlgorithm.domain.Simulation;
import com.blablacar.mowerAlgorithm.service.SimulationFactory;
import com.blablacar.mowerAlgorithm.service.SimulationFileReader;

import java.util.List;

public class MowerApplication {

    public static void main(String[] args) {
        if (args != null && args.length > 0 && args[0] != null) {
            SimulationFileReader reader = new SimulationFileReader();
            List<String> lines = reader.read(reader.getPath(args[0]));

            Simulation simulation = SimulationFactory.create(lines);
            simulation.run();
        } else {
            System.err.println("Please add input file path");
        }
    }
}

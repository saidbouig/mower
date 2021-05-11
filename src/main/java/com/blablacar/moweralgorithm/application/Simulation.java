package com.blablacar.moweralgorithm.application;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<MowerAgent> mowerAgents;

    private Simulation(List<MowerAgent> mowerAgents) {
        this.mowerAgents = new ArrayList<>(mowerAgents);
    }

    public static Simulation of(List<MowerAgent> mowerAgents){
        return new Simulation(mowerAgents);
    }

    public void run() throws InterruptedException {
        mowerAgents.forEach(MowerAgent::runCommands);
        for (MowerAgent mowerAgent : mowerAgents) {
            mowerAgent.join();
        }
    }
}

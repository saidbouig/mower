package com.blablacar.moweralgorithm.application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulation {

    private final List<MowerAgent> mowerAgents;

    private Simulation(List<MowerAgent> mowerAgents) {
        this.mowerAgents = new ArrayList<>(mowerAgents);
    }

    public static Simulation of(List<MowerAgent> mowerAgents){
        return new Simulation(mowerAgents);
    }

    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(mowerAgents.size());
        mowerAgents.forEach(mowerAgent -> {
            try {
                String result = executorService.submit(mowerAgent).get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}

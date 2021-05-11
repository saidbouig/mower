package com.blablacar.moweralgorithm;

import org.junit.jupiter.api.Test;

class MowerApplicationTest {

    @Test
    void should_launch_simulation_with_multiple_mowers() throws InterruptedException {
        new MowerApplication().main(new String[]{"mower.txt"});
    }
}

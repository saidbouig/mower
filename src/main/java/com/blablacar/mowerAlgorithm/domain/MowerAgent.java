package com.blablacar.mowerAlgorithm.domain;

import java.util.List;

public class MowerAgent extends Thread{
    private final Mower mower;
    private final Lawn lawn;
    private final List<Instruction> instructions;

    private MowerAgent(Mower mower, Lawn lawn, List<Instruction> instructions) {
        this.mower = mower;
        this.lawn = lawn;
        this.instructions = instructions;
    }

    public static MowerAgent of(Mower mower, Lawn lawn, List<Instruction> instructions){
        return new MowerAgent(mower, lawn, instructions);
    }

    public void runCommands(){
        instructions.forEach(instruction -> {
            switch (instruction)  {
                case F : mower.moveToForward(lawn); break;
                case R : mower.rotateToRight(); break;
                case L : mower.rotateToLeft(); break;
            }
        });
    }
}

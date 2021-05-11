package com.blablacar.mowerAlgorithm.service;

import com.blablacar.mowerAlgorithm.domain.*;

import java.util.List;

public class MowerAgent extends Thread{
    private final IMower mower;
    private final ILawn lawn;
    private final List<Instruction> instructions;

    private MowerAgent(IMower mower, ILawn lawn, List<Instruction> instructions) {
        this.mower = mower;
        this.lawn = lawn;
        this.instructions = instructions;
    }

    public static MowerAgent of(IMower mower, ILawn lawn, List<Instruction> instructions){
        return new MowerAgent(mower, lawn, instructions);
    }

    public void runCommands(){
        instructions.forEach(instruction -> {
            switch (instruction)  {
                case F : mower.moveToForward((Lawn) lawn); break;
                case R : mower.rotateToRight(); break;
                case L : mower.rotateToLeft(); break;
            }
        });
        System.out.println(this);
    }

    @Override
    public String toString() {
        return mower.toString();
    }
}

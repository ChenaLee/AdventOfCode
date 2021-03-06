package advent2020.chenalee.day12.processor;

import advent2020.chenalee.day12.Instruction;
import advent2020.chenalee.day12.State;

public class EastInstructionProcessor implements InstructionProcessor {
    public State process(State startState, Instruction instruction) {
        return new State(startState.getXPos() + instruction.getValue(), startState.getYPos(),
                startState.getFacingDirection(), startState.getShipXPos(), startState.getShipYPos());
    }
}

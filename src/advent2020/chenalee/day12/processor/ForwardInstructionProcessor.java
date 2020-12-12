package advent2020.chenalee.day12.processor;

import advent2020.chenalee.day12.Instruction;
import advent2020.chenalee.day12.State;

public class ForwardInstructionProcessor implements InstructionProcessor {
    public State process(State startState, Instruction instruction) {
        switch (startState.getFacingDirection()) {
            case "N":
                return new State(startState.getXPos(), startState.getYPos() + instruction.getValue(),
                        startState.getFacingDirection());
            case "S":
                return new State(startState.getXPos(), startState.getYPos() - instruction.getValue(),
                        startState.getFacingDirection());
            case "W":
                return new State(startState.getXPos() - instruction.getValue(), startState.getYPos(),
                        startState.getFacingDirection());
            case "E":
                return new State(startState.getXPos() + instruction.getValue(), startState.getYPos(),
                        startState.getFacingDirection());
            default:
                throw new RuntimeException();
        }
    }
}

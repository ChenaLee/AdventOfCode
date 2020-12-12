package advent2020.chenalee.day12.processor.waypointProcessor;

import advent2020.chenalee.day12.Instruction;
import advent2020.chenalee.day12.State;
import advent2020.chenalee.day12.processor.InstructionProcessor;

public class WaypointForwardInstructionProcessor implements InstructionProcessor {
    public State process(State startState, Instruction instruction) {
        return new State(startState.getXPos(), startState.getYPos(),
                startState.getFacingDirection(),
                startState.getShipXPos() + startState.getXPos()*instruction.getValue(),
                startState.getShipYPos() + startState.getYPos()*instruction.getValue());
    }
}

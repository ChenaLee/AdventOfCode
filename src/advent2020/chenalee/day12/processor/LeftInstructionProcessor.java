package advent2020.chenalee.day12.processor;

import advent2020.chenalee.day12.DirectionDegreeMapper;
import advent2020.chenalee.day12.Instruction;
import advent2020.chenalee.day12.State;

public class LeftInstructionProcessor implements InstructionProcessor {
    public State process(State startState, Instruction instruction) {
        int currentDegree = DirectionDegreeMapper.getDegree(startState.getFacingDirection());
        int newDegree = currentDegree - instruction.getValue();
        String newDirection = DirectionDegreeMapper.getDirection(newDegree);
        return new State(startState.getXPos(), startState.getYPos(), newDirection);
    }
}

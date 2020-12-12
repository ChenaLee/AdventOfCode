package advent2020.chenalee.day12.processor.waypointProcessor;

import advent2020.chenalee.day12.Instruction;
import advent2020.chenalee.day12.State;
import advent2020.chenalee.day12.processor.InstructionProcessor;

public class WaypointLeftInstructionProcessor implements InstructionProcessor {
    private static final VectorRotator vectorRotator = new VectorRotator();
    public State process(State startState, Instruction instruction) {
        return vectorRotator.rotate(startState, -instruction.getValue());
    }
}

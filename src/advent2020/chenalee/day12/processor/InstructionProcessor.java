package advent2020.chenalee.day12.processor;

import advent2020.chenalee.day12.Instruction;
import advent2020.chenalee.day12.State;

public interface InstructionProcessor {
    State process(State startState, Instruction instruction);
}

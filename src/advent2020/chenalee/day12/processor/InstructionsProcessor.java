package advent2020.chenalee.day12.processor;

import advent2020.chenalee.day12.Instruction;
import advent2020.chenalee.day12.State;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class InstructionsProcessor {
    private final IInstructionProcessorFactory factory;

    public State processInstructions(State startState, List<Instruction> instructions) {
        State endState = startState;
        for (Instruction instruction : instructions) {
            InstructionProcessor processor = factory.getProcessor(instruction.getInstructionType());
            endState = processor.process(startState, instruction);
            startState = endState;
        }
        return endState;
    }
}

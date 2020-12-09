package advent2020.chenalee.day08;

import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
class TerminationDeterminator {
    List<Instruction> instructions;

    TerminationResult process(Integer startingInstruction, Integer startingAccumulator, List<Integer> processedInstructions) {
        int accumulator = startingAccumulator;
        int instructionIndex = startingInstruction;
        boolean canTerminate = false;
        while (!processedInstructions.contains(instructionIndex)) {
            Instruction currentInstruction = instructions.get(instructionIndex);
            processedInstructions.add(instructionIndex);

            if (currentInstruction.getInstructionType().equals(InstructionType.ACC)) {
                accumulator += currentInstruction.getValue();
                instructionIndex++;
            } else if (currentInstruction.getInstructionType().equals(InstructionType.NOP)) {
                instructionIndex++;
            } else if (currentInstruction.getInstructionType().equals(InstructionType.JMP)) {
                instructionIndex += currentInstruction.getValue();
            }

            if (instructionIndex >= instructions.size()) {
                canTerminate = true;
                break;
            }
        }
        return new TerminationResult(canTerminate, accumulator, processedInstructions);
    }
}

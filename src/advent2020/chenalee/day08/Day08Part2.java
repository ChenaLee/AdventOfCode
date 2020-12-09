package advent2020.chenalee.day08;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day08Part2 {
    public static void main(String[] args) throws IOException {
        List<String> instructionsString = TestDataReader.readAllLines("day08.txt");
        InstructionParser parser = new InstructionParser();
        List<Instruction> instructions = parser.parse(instructionsString);
        TerminationDeterminator terminationDeterminator = new TerminationDeterminator(instructions);


        int instructionIndex = 0;
        TerminationResult result = terminationDeterminator.process(instructionIndex, 0, new ArrayList<>());
        List<Integer> processedInstructions = result.getProcessedInstructions();
        int accumulator = result.getLastAccumulatorValue();

        while (true) {
            Integer revertedInstructionIndex = -1;
            while (true) {
                revertedInstructionIndex = processedInstructions.remove(processedInstructions.size()-1);
                Instruction revertedInstruction = instructions.get(revertedInstructionIndex);
                if (revertedInstruction.getInstructionType().equals(InstructionType.ACC)) {
                    accumulator -= revertedInstruction.getValue();
                } else if (revertedInstruction.getInstructionType().equals(InstructionType.JMP)) {
                    instructionIndex = revertedInstructionIndex + 1;
                    break;
                } else if (revertedInstruction.getInstructionType().equals(InstructionType.NOP)) {
                    instructionIndex = revertedInstructionIndex + revertedInstruction.getValue();
                    break;
                }
            }

            List<Integer> retriedProcessInstruction = new ArrayList<>(processedInstructions);
            retriedProcessInstruction.add(revertedInstructionIndex);
            TerminationResult retryResult = terminationDeterminator.process(instructionIndex, accumulator, retriedProcessInstruction);
            if (retryResult.isTerminated()) {
                System.out.println(retryResult.getLastAccumulatorValue());
                break;
            }
        }
    }
}

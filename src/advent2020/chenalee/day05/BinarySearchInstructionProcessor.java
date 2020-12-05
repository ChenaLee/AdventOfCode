package advent2020.chenalee.day05;

class BinarySearchInstructionProcessor {
    int process(int rangeStart, int rangeEnd, String instruction) {
        if (rangeEnd - rangeStart == 1) {
            return rangeStart;
        }
        if (instruction.isEmpty()) {
            throw new RuntimeException("Instruction isn't complete. Could not complete search before the instruction runs out.");
        }

        String firstStepInstruction = instruction.substring(0,1);
        String nextInstruction = instruction.substring(1);
        int rangeHalf = rangeStart + (rangeEnd - rangeStart)/2;

        if (firstStepInstruction.equals("F") || firstStepInstruction.equals("L")) {
            rangeEnd = rangeHalf;
        } else if (firstStepInstruction.equals("B") || firstStepInstruction.equals("R")) {
            rangeStart = rangeHalf;
        } else {
            throw new RuntimeException("Invalid instruction found.");
        }
        return process(rangeStart, rangeEnd, nextInstruction);
    }
}

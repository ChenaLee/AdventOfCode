package advent2020.chenalee.day12;

import java.util.ArrayList;
import java.util.List;

class InstructionParser {
    List<Instruction> parse(List<String> instructionsString) {
        List<Instruction> instructions = new ArrayList<>();
        for (String instructionString : instructionsString) {
            String[] instructionParts = instructionString.split("(?<=\\D)(?=\\d)");
            Instruction instruction = new Instruction(instructionParts[0], Integer.parseInt(instructionParts[1]));
            instructions.add(instruction);
        }
        return instructions;
    }
}

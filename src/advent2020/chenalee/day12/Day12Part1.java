package advent2020.chenalee.day12;

import advent2020.chenalee.day12.processor.InstructionProcessorFactory;
import advent2020.chenalee.day12.processor.InstructionsProcessor;
import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;

import static java.lang.Math.abs;

public class Day12Part1 {
    private static final InstructionParser parser = new InstructionParser();
    private static final InstructionProcessorFactory factory = new InstructionProcessorFactory();
    private static final InstructionsProcessor processor = new InstructionsProcessor(factory);

    public static void main(String[] args) throws IOException {
        List<String> instructionStrings = TestDataReader.readAllLines("day12.txt");
        List<Instruction> instructions = parser.parse(instructionStrings);
        State startState = new State(0, 0, "E");
        State endState = processor.processInstructions(startState, instructions);
        System.out.println(abs(endState.getXPos()) + abs(endState.getYPos()));
    }
}

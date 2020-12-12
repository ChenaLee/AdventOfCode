package advent2020.chenalee.day12;

import advent2020.chenalee.day12.processor.InstructionsProcessor;
import advent2020.chenalee.day12.processor.waypointProcessor.WaypointInstructionProcessorFactory;
import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;

import static java.lang.Math.abs;

public class Day12Part2 {
    private static final InstructionParser parser = new InstructionParser();
    private static final WaypointInstructionProcessorFactory factory = new WaypointInstructionProcessorFactory();
    private static final InstructionsProcessor processor = new InstructionsProcessor(factory);

    public static void main(String[] args) throws IOException {
        List<String> instructionStrings = TestDataReader.readAllLines("day12.txt");
        List<Instruction> instructions = parser.parse(instructionStrings);
        State startState = new State(10, 1, "E", 0, 0);
        State endState = processor.processInstructions(startState, instructions);
        System.out.println(abs(endState.getShipXPos()) + abs(endState.getShipYPos()));
    }
}

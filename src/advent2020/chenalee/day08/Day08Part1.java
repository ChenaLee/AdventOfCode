package advent2020.chenalee.day08;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day08Part1 {
    public static void main(String[] args) throws IOException {
        List<String> instructionsString = TestDataReader.readAllLines("day08.txt");
        InstructionParser parser = new InstructionParser();
        List<Instruction> instructions = parser.parse(instructionsString);
        TerminationDeterminator terminationDeterminator = new TerminationDeterminator(instructions);
        TerminationResult result = terminationDeterminator.process(0, 0, new ArrayList<>());
        System.out.println(result.getLastAccumulatorValue());
    }
}

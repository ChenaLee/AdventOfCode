package advent2020.chenalee.day05;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;

public class Day05Part1 {
    public static void main(String[] args) throws IOException {
        List<String> seatBinarySearchInstructions = TestDataReader.readAllLines("day05.txt");
        BinarySearchInstructionProcessor binarySearchInstructionProcessor = new BinarySearchInstructionProcessor();

        int maxSeatNumber = seatBinarySearchInstructions.stream()
                .mapToInt(instruction -> binarySearchInstructionProcessor.process(0, 128, instruction.substring(0,7)) * 8
                        + binarySearchInstructionProcessor.process(0, 8, instruction.substring(7,10)))
                .max().orElseThrow(RuntimeException::new);
        System.out.println(maxSeatNumber);
    }
}

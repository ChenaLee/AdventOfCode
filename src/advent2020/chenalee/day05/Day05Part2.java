package advent2020.chenalee.day05;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day05Part2 {
    public static void main(String[] args) throws IOException {
        List<String> seatBinarySearchInstructions = TestDataReader.readAllLines("day05.txt");
        BinarySearchInstructionProcessor binarySearchInstructionProcessor = new BinarySearchInstructionProcessor();

        List<Integer> seats = seatBinarySearchInstructions.stream()
                .map(instruction -> binarySearchInstructionProcessor.process(0, 128, instruction.substring(0,7)) * 8
                        + binarySearchInstructionProcessor.process(0, 8, instruction.substring(7,10)))
                .sorted()
                .collect(Collectors.toList());
        Optional<Integer> missingSeat = findMissingSeatInPlane(seats);

        System.out.println(missingSeat.orElse(-1));
    }

    private static Optional<Integer> findMissingSeatInPlane(List<Integer> sortedSeats) {
        int currentRow = sortedSeats.get(0) / 8;
        int seatRowStart = 0;

        while (seatRowStart < sortedSeats.size()){
            Optional<Integer> missingSeat = findMissingSeatInRow(sortedSeats.subList(seatRowStart, seatRowStart+8), currentRow);
            if (missingSeat.isPresent()) {
                return missingSeat;
            }
            seatRowStart += 8;
            currentRow++;
        }
        return Optional.empty();
    }

    private static Optional<Integer> findMissingSeatInRow(List<Integer> seatsInRow, int currentRow) {
        int currentColumn = 0;
        for (int seatInRow :seatsInRow) {
            int expectedSeat = currentRow * 8 + currentColumn;
            if(seatInRow != expectedSeat) {
                return Optional.of(expectedSeat);
            }
            currentColumn++;
        }
        return Optional.empty();
    }

}

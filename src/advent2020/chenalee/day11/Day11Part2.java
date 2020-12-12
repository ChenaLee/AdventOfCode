package advent2020.chenalee.day11;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Day11Part2 {
    private static final SeatStateDeterminerBasedOnVisibleSeats seatStateDeterminer = new SeatStateDeterminerBasedOnVisibleSeats();

    public static void main(String[] args) throws IOException {
        List<String> seatsLayoutString = TestDataReader.readAllLines("day11.txt");

        List<List<String>> seats = seatsLayoutString.stream()
                .map(seatsRowString -> Arrays.asList(seatsRowString.split("")))
                .collect(Collectors.toList());

        while (true) {
            List<List<String>> changedSeats = seatStateDeterminer.getNextIterationSeats(seats);
            if (new HashSet<>(changedSeats).equals(new HashSet<>(seats))) {
                System.out.println(Util.countOccupiedSeats(changedSeats));
                break;
            }
            seats = changedSeats;
        }
    }
}

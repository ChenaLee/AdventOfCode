package advent2020.chenalee.day13;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day13Part1 {
    public static void main(String[] args) throws IOException {
        List<String> busRideInput = TestDataReader.readAllLines("day13.txt");
        int earliestDeparture = Integer.parseInt(busRideInput.get(0));
        List<Integer> busIds = Arrays.stream(busRideInput.get(1).split(","))
                .filter(busId -> !busId.equals("x"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int numberOfBusRound = earliestDeparture / busIds.get(0) + ((earliestDeparture % busIds.get(0) == 0) ? 0 : 1);
        int earliestBusDeparture = numberOfBusRound * busIds.get(0);
        int earliestBusId = busIds.get(0);
        for (int busId : busIds.subList(1, busIds.size())) {
            int numberOfCurrentBusRound  = earliestDeparture / busId + ((earliestDeparture % busId == 0) ? 0 : 1);
            int currentBusDeparture = numberOfCurrentBusRound * busId;
            if (earliestBusDeparture > currentBusDeparture) {
                earliestBusDeparture = currentBusDeparture;
                earliestBusId = busId;
            }
        }

        System.out.println((earliestBusDeparture - earliestDeparture) * earliestBusId);
    }
}

package advent2020.chenalee.day13;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day13Part2 {
    public static void main(String[] args) throws IOException {
        List<String> busRideInput = TestDataReader.readAllLines("day13.txt");
        List<String> busIds = Arrays.stream(busRideInput.get(1).split(","))
                .collect(Collectors.toList());
        Map<Integer, Integer> busIdsWithIndex = new HashMap<>();
        for (int i = 0; i < busIds.size(); i++) {
            if (busIds.get(i).equals("x")) {
                continue;
            }
            busIdsWithIndex.put(Integer.parseInt(busIds.get(i)), i);
        }
        List<Integer> busIdKeys = busIds.stream().filter(busId -> !busId.equals("x")).map(Integer::parseInt).collect(Collectors.toList());

        long coprimeProducts = busIdKeys.stream().mapToLong(busId -> (long)busId).reduce(1L, (subTotal, element) -> subTotal*element);
        long t = 0;
        for (Integer busId : busIdKeys) {
            int temp = (busIdsWithIndex.get(busId) / busId + ((busIdsWithIndex.get(busId) % busId == 0) ? 0 : 1)) * busId;
            int remainder = (temp - busIdsWithIndex.get(busId)) % busId;
            long N_i = coprimeProducts / busId;

            long reducedCoefficient = N_i % busId;
            int guessedModularInverseSolution = 1;
            while ((reducedCoefficient * guessedModularInverseSolution) % busId != 1) {
                guessedModularInverseSolution++;
            }
            int x_i = guessedModularInverseSolution;

            t += remainder*N_i*x_i;
        }
        t = t % coprimeProducts;
        System.out.println(t);
    }
}

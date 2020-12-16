package advent2020.chenalee.day15;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day15Part2 {
    private static final NumberGameProcessor processor = new NumberGameProcessor();

    public static void main(String[] args) throws IOException {
        List<String> lines = TestDataReader.readAllLines("day15.txt");
        List<Integer> initialNumbers = Arrays.asList(lines.get(0).split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int lastNumber = processor.getLastNumberSpoken(initialNumbers, 30000000);
        System.out.println(lastNumber);
    }
}

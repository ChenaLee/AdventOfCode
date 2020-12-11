package advent2020.chenalee.day10;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day10Part1 {
    public static void main(String[] args) throws IOException {
        List<String> numbersString = TestDataReader.readAllLines("day10.txt");
        numbersString.add("0");
        List<Integer> numbers = numbersString.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> differenceCounts = Arrays.asList(0, 0, 0, 0);

        for (int i = 1;  i < numbers.size(); i++) {
            int currentDifference = numbers.get(i) - numbers.get(i-1);
            differenceCounts.set(currentDifference, differenceCounts.get(currentDifference)+1);
        }
        differenceCounts.set(3, differenceCounts.get(3)+1);
        System.out.println(differenceCounts.get(1) * differenceCounts.get(3));
    }
}

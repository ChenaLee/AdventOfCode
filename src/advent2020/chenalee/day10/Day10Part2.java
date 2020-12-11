package advent2020.chenalee.day10;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day10Part2 {
    public static void main(String[] args) throws IOException {
        List<String> numbersString = TestDataReader.readAllLines("day10.txt");
        numbersString.add("0");
        List<Long> numbers = numbersString.stream()
                .mapToLong(Long::parseLong)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        ValidCombinationCounter counter = new ValidCombinationCounter(numbers);
        long count = counter.countCombinationFrom(0, numbers.size()-1);
        System.out.println(count);
    }
}

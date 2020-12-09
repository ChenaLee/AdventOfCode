package advent2020.chenalee.day09;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day09Part1 {
    public static void main(String[] args) throws IOException {
        List<String> numbersString = TestDataReader.readAllLines("day09.txt");
        List<Long> numbers = numbersString.stream()
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());
        BadEntrySearcher badEntrySearcher = new BadEntrySearcher();

        int preambleCount = 25;
        long badEntry = badEntrySearcher.search(numbers, preambleCount);
        System.out.println(badEntry);
    }
}

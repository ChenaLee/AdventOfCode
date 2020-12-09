package advent2020.chenalee.day09;

import advent2020.chenalee.util.SumTester;
import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day09Part2 {
    public static void main(String[] args) throws IOException {
        List<String> numbersString = TestDataReader.readAllLines("day09.txt");
        List<Long> numbers = numbersString.stream()
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());
        SumTester sumTester = new SumTester();
        BadEntrySearcher badEntrySearcher = new BadEntrySearcher();

        int preambleCount = 25;
        long badEntry = badEntrySearcher.search(numbers, preambleCount);

        // Do to sum range
        List<Long> range = sumTester.findRangeSum(numbers, badEntry);
        long minNum = range.stream().mapToLong(e->e).min().orElse(-1);
        long maxNum = range.stream().mapToLong(e->e).max().orElse(-1);
        System.out.println(minNum + maxNum);
    }
}

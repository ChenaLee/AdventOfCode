package advent2020.chenalee.day01;

import advent2020.chenalee.util.SumTester;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day01Part1 {

    public static void main(String[] args) throws IOException {
        List<String> numbersInString = Files.readAllLines(Paths.get("src/advent2020/chenalee/data/day01.txt"));
        List<Long> numbers = numbersInString.stream().map(Long::parseLong).collect(Collectors.toList());
        SumTester sumTester = new SumTester();

        List<Long> twoSumNumbers = sumTester.findTwoSum(numbers, 2020);
        System.out.println(twoSumNumbers.get(0)*twoSumNumbers.get(1));
    }
}

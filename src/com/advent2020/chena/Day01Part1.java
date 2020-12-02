package com.advent2020.chena;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day01Part1 {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        List<String> numbersInString = Files.readAllLines(Paths.get("src/com/advent2020/chena/data/day01.txt"));
        List<Integer> numbers = numbersInString.stream().map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(numbers);

        int largeNumberIndex = numbers.size() -1;
        int smallNumberIndex = 0;

        while (smallNumberIndex < largeNumberIndex) {
            int largeNumber = numbers.get(largeNumberIndex);
            int smallNumber = numbers.get(smallNumberIndex);

            if (largeNumber + smallNumber == 2020) {
                System.out.println(largeNumber*smallNumber);
                break;
            }
            if (largeNumber + smallNumber > 2020)  {
                largeNumberIndex--;
            }
            if (largeNumber + smallNumber < 2020) {
                smallNumberIndex++;
            }
        }
    }
}

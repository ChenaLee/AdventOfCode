package com.advent2020.chena;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day01Part2 {

    public static void main(String[] args) throws IOException {
        List<String> numbersInString = Files.readAllLines(Paths.get("src/com/advent2020/chena/data/day01.txt"));
        List<Integer> numbers = numbersInString.stream().map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(numbers);

        int firstChoiceNumberIndex = 0;

        while (firstChoiceNumberIndex < numbers.size()-2) {
            int firstChoiceNumber = numbers.get(firstChoiceNumberIndex);
            int smallNumberIndex = firstChoiceNumberIndex + 1;
            int largeNumberIndex = numbers.size() -1;

            while (smallNumberIndex < largeNumberIndex) {
                int largeNumber = numbers.get(largeNumberIndex);
                int smallNumber = numbers.get(smallNumberIndex);

                if (firstChoiceNumber + largeNumber + smallNumber == 2020) {
                    System.out.println(firstChoiceNumber*largeNumber*smallNumber);
                    break;
                }
                if (firstChoiceNumber + largeNumber + smallNumber > 2020)  {
                    largeNumberIndex--;
                }
                if (firstChoiceNumber + largeNumber + smallNumber < 2020) {
                    smallNumberIndex++;
                }
            }

            firstChoiceNumberIndex++;
        }
    }
}

package advent2020.chenalee.day09;

import advent2020.chenalee.util.SumTester;

import java.util.ArrayList;
import java.util.List;

class BadEntrySearcher {
    private static final SumTester sumTester = new SumTester();

    long search(List<Long> numbers, int preambleCount) {
        for (int i = preambleCount; i < numbers.size(); i++) {
            List<Long> candidates = new ArrayList<>(numbers.subList(i-preambleCount, i));
            List<Long> twoSumFound = sumTester.findTwoSum(candidates, numbers.get(i));
            if (twoSumFound.isEmpty()) {
                return numbers.get(i);
            }
        }
        throw new RuntimeException();
    }
}

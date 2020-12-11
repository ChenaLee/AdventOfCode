package advent2020.chenalee.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ValidCombinationCounter {
    private final List<Long> numbers;
    private Map<Integer, Long> combinationFromIndex;

    ValidCombinationCounter(List<Long> numbers) {
        this.numbers = numbers;
        this.combinationFromIndex = new HashMap<>();
    }

    long countCombinationFrom(int startIndex, int endIndex) {
        // start from index, if it was already calculated, return that value.
        if (combinationFromIndex.get(startIndex) != null) {
            return combinationFromIndex.get(startIndex);
        }
        // if I'm not last index(goal), done.
        if (startIndex == endIndex) {
            combinationFromIndex.put(startIndex, 1L);
            return 1L;
        }
        // Find all possible next index (max 3)
        List<Integer> nextIndices = new ArrayList<>();
        for (int i = startIndex+1; i <= endIndex && numbers.get(i) <= numbers.get(startIndex)+3; i++) {
            nextIndices.add(i);
        }
        // if there's none, it's a failing path.
        if (nextIndices.isEmpty()) {
            combinationFromIndex.put(startIndex, 0L);
            return 0L;
        }
        // count for all next steps
        long totalCombination = 0L;
        for (int nextIndex :  nextIndices) {
            totalCombination += countCombinationFrom(nextIndex, endIndex);
        }

        combinationFromIndex.put(startIndex, totalCombination);
        return totalCombination;
    }
}
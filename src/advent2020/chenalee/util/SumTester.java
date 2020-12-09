package advent2020.chenalee.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumTester {
    public List<Long> findTwoSum(List<Long> candidates, long TargetNumber) {
        Collections.sort(candidates);

        int largeNumberIndex = candidates.size() -1;
        int smallNumberIndex = 0;

        while (smallNumberIndex < largeNumberIndex) {
            long largeNumber = candidates.get(largeNumberIndex);
            long smallNumber = candidates.get(smallNumberIndex);

            if (largeNumber + smallNumber == TargetNumber) {
                return Arrays.asList(largeNumber, smallNumber);
            }
            if (largeNumber + smallNumber > TargetNumber)  {
                largeNumberIndex--;
            }
            if (largeNumber + smallNumber < TargetNumber) {
                smallNumberIndex++;
            }
        }
        return Collections.emptyList();
    }

    public List<Long> findRangeSum(List<Long> candidates, long targetNumber) {
        int rangeEndIndex = 1;
        int rangeStartIndex = 0;

        while (rangeEndIndex < candidates.size()) {
            long testSum = sumRange(candidates, rangeStartIndex, rangeEndIndex);

            if (testSum == targetNumber) {
                return candidates.subList(rangeStartIndex, rangeEndIndex+1);
            } else if (testSum > targetNumber) {
                rangeStartIndex++;
            } else {
                rangeEndIndex++;
            }

            if (rangeEndIndex == rangeStartIndex) {
                rangeEndIndex++;
            }
        }
        return Collections.emptyList();
    }

    private long sumRange(List<Long> candidates, int rangeStartIndex, int rangeEndIndex) {
        long sum = 0;
        for (int i = rangeStartIndex; i <= rangeEndIndex; i++) {
            sum += candidates.get(i);
        }
        return sum;
    }
}

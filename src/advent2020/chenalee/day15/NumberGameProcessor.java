package advent2020.chenalee.day15;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NumberGameProcessor {
    int getLastNumberSpoken(List<Integer> initialNumbers, int lastTurn) {
        Map<Integer, LinkedList<Integer>> numToTurnHistory = new HashMap<>();

        for (int turn = 0; turn < initialNumbers.size(); turn++) {
            int initNum = initialNumbers.get(turn);
            recordHistory(numToTurnHistory, initNum, turn);
        }

        int lastNumSpoken = initialNumbers.get(initialNumbers.size() -1);
        for (int turn = initialNumbers.size(); turn < lastTurn; turn++) {
            int num;
            if (numToTurnHistory.get(lastNumSpoken).size() == 1) {
                num = 0;
            } else {
                num = numToTurnHistory.get(lastNumSpoken).getFirst() - numToTurnHistory.get(lastNumSpoken).get(1);
            }
            recordHistory(numToTurnHistory, num, turn);
            lastNumSpoken = num;
        }
        return lastNumSpoken;
    }

    private void recordHistory(Map<Integer, LinkedList<Integer>> numToTurnHistory, int num, int turn) {
        if (numToTurnHistory.get(num) == null) {
            LinkedList<Integer> turnHistory = new LinkedList<>();
            turnHistory.addFirst(turn);
            numToTurnHistory.put(num, turnHistory);
        } else {
            numToTurnHistory.get(num).addFirst(turn);
        }
    }
}

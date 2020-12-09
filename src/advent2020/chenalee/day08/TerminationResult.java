package advent2020.chenalee.day08;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
class TerminationResult {
    private boolean isTerminated;
    private int lastAccumulatorValue;
    private List<Integer> processedInstructions;
}

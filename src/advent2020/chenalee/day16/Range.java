package advent2020.chenalee.day16;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Range {
    private int min;
    private int max;

    public boolean isInRange(int num) {
        return num >= min && num <= max;
    }
}

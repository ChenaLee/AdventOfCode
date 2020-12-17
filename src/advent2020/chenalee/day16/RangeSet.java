package advent2020.chenalee.day16;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RangeSet {
    private List<Range> ranges;

    public boolean isInRange(int num) {
        for (Range range : ranges) {
            if (range.isInRange(num)) {
                return true;
            }
        }
        return false;
    }
}

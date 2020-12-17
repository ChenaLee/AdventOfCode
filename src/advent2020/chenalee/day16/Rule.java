package advent2020.chenalee.day16;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rule {
    private String name;
    private RangeSet rangeSet;

    public boolean validate(int num) {
        return rangeSet.isInRange(num);
    }
}

package advent2020.chenalee.day14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Instruction {
    private long memLocation;
    private long value;
}

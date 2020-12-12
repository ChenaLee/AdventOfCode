package advent2020.chenalee.day12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Instruction {
    private String instructionType;
    private int value;
}

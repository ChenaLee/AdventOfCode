package advent2020.chenalee.day08;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Instruction {
    private InstructionType instructionType;
    private int value;
}

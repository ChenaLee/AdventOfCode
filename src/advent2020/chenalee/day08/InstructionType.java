package advent2020.chenalee.day08;

import java.util.HashMap;
import java.util.Map;

public enum InstructionType {
    NOP("nop"),
    ACC("acc"),
    JMP("jmp");

    final String name;
    InstructionType(String name) {
        this.name = name;
    }

    private static final Map<String, InstructionType> BY_NAME = new HashMap<>();

    static {
        for (InstructionType e: values()) {
            BY_NAME.put(e.name, e);
        }
    }

    static InstructionType getByName(String name) {
        return BY_NAME.get(name);
    }
}

package advent2020.chenalee.day14;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day14Part1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = TestDataReader.getScannerForFile("day14.txt", "mask\\s=\\s");
        Map<Long, Long> memories = new HashMap<>();

        while (scanner.hasNext()) {
            String section = scanner.next();
            List<String> bitmaskInstruction = Arrays.asList(section.split("\\n"));
            // parse mask
            String mask = bitmaskInstruction.get(0);
            // parse instructions
            List<Instruction> instructions = bitmaskInstruction.subList(1, bitmaskInstruction.size()).stream()
                    .map(memLine -> memLine.split("(\\[|\\]|\\s=\\s)"))
                    .map(memLineSplited -> new Instruction(Integer.parseInt(memLineSplited[1]), Integer.parseInt(memLineSplited[3])))
                    .collect(Collectors.toList());

            // process bitmask and memory writing
            for (Instruction instruction : instructions) {
                long value = instruction.getValue();

                char[] binaryValue = String.format("%36s", Long.toBinaryString(value)).replace(' ', '0').toCharArray();
                for (int i = 0; i < mask.length(); i++) {
                    char maskAtBit = mask.charAt(mask.length() -1 -i);
                    if (maskAtBit == 'X') {
                        continue;
                    }
                    binaryValue[binaryValue.length -1 -i] = maskAtBit;
                }
                String binaryValueString = String.valueOf(binaryValue);
                memories.put(instruction.getMemLocation(), Long.parseLong(binaryValueString, 2));
            }
        }

        System.out.println(memories.values().stream().reduce(0L, Long::sum));
    }
}

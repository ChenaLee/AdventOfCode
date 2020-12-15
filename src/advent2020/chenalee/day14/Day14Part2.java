package advent2020.chenalee.day14;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day14Part2 {
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
                long address = instruction.getMemLocation();

                char[] binaryAddress = String.format("%36s", Long.toBinaryString(address)).replace(' ', '0').toCharArray();
                List<char[]> binaryAddresses = Arrays.asList(binaryAddress);
                for (int i = 0; i < mask.length(); i++) {
                    char maskAtBit = mask.charAt(mask.length() -1 -i);
                    if (maskAtBit == '1') {
                        List<char[]> newBinaryAddresses = new ArrayList<>();
                        for (char[] binaryAddressElem : binaryAddresses) {
                            binaryAddressElem[binaryAddress.length -1 -i] = '1';
                            newBinaryAddresses.add(binaryAddressElem.clone());
                        }
                        binaryAddresses = newBinaryAddresses;
                    } else if(maskAtBit == 'X') {
                        List<char[]> newBinaryAddresses = new ArrayList<>();
                        for (char[] binaryAddressElem : binaryAddresses) {
                            binaryAddressElem[binaryAddress.length -1 -i] = '0';
                            newBinaryAddresses.add(binaryAddressElem.clone());
                            binaryAddressElem[binaryAddress.length -1 -i] = '1';
                            newBinaryAddresses.add(binaryAddressElem.clone());
                        }
                        binaryAddresses = newBinaryAddresses;
                    }
                }

                for (char[] binaryAddressElem : binaryAddresses) {
                    String binaryAddressString = String.valueOf(binaryAddressElem);
                    memories.put(Long.parseLong(binaryAddressString, 2), instruction.getValue());
                }
            }
        }

        System.out.println(memories.values().stream().reduce(0L, Long::sum));
    }
}

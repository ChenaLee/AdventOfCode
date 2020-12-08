package advent2020.chenalee.day07;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Day07Part1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = TestDataReader.getScannerForFile("day07.txt", "\\n");

        BagParser parser = new BagParser();
        Map<String, Bag> bagsByName = parser.parse(scanner);

        BagSearcher bagSearcher = new BagSearcher(bagsByName);
        int result = bagSearcher.countAllBagContaining("shiny gold");
        System.out.println(result -1);
    }

}

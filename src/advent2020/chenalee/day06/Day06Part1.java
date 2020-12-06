package advent2020.chenalee.day06;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Day06Part1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = TestDataReader.getScannerForFile("day06.txt", "\\n\\s*\\n");
        TravelGroupParser travelGroupParser = new TravelGroupParser();

        List<TravelGroup> travelGroups = travelGroupParser.parse(scanner);
        Integer sumOfAllYesAnswers = travelGroups.stream()
                .mapToInt(travelGroup -> travelGroup.unionCustomDeclarationForm().getYesAnswers().length())
                .sum();

        System.out.println(sumOfAllYesAnswers);
    }
}

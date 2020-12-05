package advent2020.chenalee.day04;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Day04Part2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = TestDataReader.getScannerForFile("day04.txt", "\\n\\s*\\n");
        List<TravelDocument> travelDocuments = TravelDocumentParser.parse(scanner);

        long validDocumentCount = travelDocuments.stream()
                .map(TravelDocumentValidator::deepValidate)
                .filter(validationResult -> validationResult).count();
        System.out.println(validDocumentCount);
    }

}

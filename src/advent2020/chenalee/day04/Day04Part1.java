package advent2020.chenalee.day04;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day04Part1 {
    public static void main(String[] args) throws IOException {
        List<String> travelDocumentLog = TestDataReader.readAllLines("day03.txt");

        TravelDocumentValidator travelDocumentValidator = new TravelDocumentCidWaivedValidator();
        List<TravelDocument> travelDocuments = new ArrayList<>();
        // parse into travelDocumentStringList
        // "([ \n])"
        Scanner scanner = TestDataReader.getScannerForFile("day04.txt", "\\n\\s*\\n");
        while (scanner.hasNext()) {
            String travelDocumentData = scanner.next();
            // parse each line by spaces
            List<String> travelDocumentMapStrings = Arrays.asList(travelDocumentData.split("([ \n])"));
            Map<String, String> dataMap = travelDocumentMapStrings.stream()
                    .map(string -> string.split(":"))
                    .collect(Collectors.toMap(strings -> strings[0], strings -> strings[1]));
            // Mapping
            TravelDocument travelDocument = new TravelDocument();
            travelDocument.byr = dataMap.get("byr");
            travelDocument.cid = dataMap.get("cid");
            travelDocument.ecl = dataMap.get("ecl");
            travelDocument.eyr = dataMap.get("eyr");
            travelDocument.hcl = dataMap.get("hcl");
            travelDocument.hgt = dataMap.get("hgt");
            travelDocument.iyr = dataMap.get("iyr");
            travelDocument.pid = dataMap.get("pid");
            travelDocuments.add(travelDocument);
        }

        long validDocumentCount = travelDocuments.stream()
                .map(travelDocument -> travelDocumentValidator.validate(travelDocument))
                .filter(validationResult -> validationResult).count();
        System.out.println(validDocumentCount);
    }

}

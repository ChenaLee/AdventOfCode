package advent2020.chenalee.day04;

import advent2020.chenalee.util.TestDataReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class TravelDocumentParser {

    static List<TravelDocument> parse(Scanner scanner) {
        List<TravelDocument> travelDocuments = new ArrayList<>();

        while (scanner.hasNext()) {
            String travelDocumentData = scanner.next();

            List<String> travelDocumentMapStrings = Arrays.asList(travelDocumentData.split("([ \n])"));
            Map<String, String> dataMap = travelDocumentMapStrings.stream()
                    .map(string -> string.split(":"))
                    .collect(Collectors.toMap(strings -> strings[0], strings -> strings[1]));

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
        return travelDocuments;
    }
}

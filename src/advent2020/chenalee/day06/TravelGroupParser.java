package advent2020.chenalee.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class TravelGroupParser {
    List<TravelGroup> parse(Scanner scanner) {
        List<TravelGroup> travelGroups = new ArrayList<>();

        while (scanner.hasNext()) {
            String travelGroupData = scanner.next();

            List<String> travelIndividuals = Arrays.asList(travelGroupData.split("\\n"));
            List<CustomDeclarationForm> customDeclarationForms = travelIndividuals.stream()
                    .map(CustomDeclarationForm::new)
                    .collect(Collectors.toList());

            travelGroups.add(new TravelGroup(customDeclarationForms));
        }
        return travelGroups;
    }
}

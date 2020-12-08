package advent2020.chenalee.day07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class BagParser {
    Map<String, Bag> parse(Scanner scanner) {
        Map<String, Bag> bagsByName = new HashMap<>();

        while (scanner.hasNext()) {
            String bagRule = scanner.next();

            List<String> bagRuleFirstSplit = Arrays.asList(bagRule.split("bags contain"));
            String bagName = bagRuleFirstSplit.get(0).trim();

            Map<String, Integer> childBags = new HashMap<>();
            List<String> bagRuleSecondSplit = Arrays.asList(bagRuleFirstSplit.get(1).split("(bags|bag)[.,]"));
            for (String childBagWithCount : bagRuleSecondSplit) {
                if (childBagWithCount.equals(" no other ")) {
                    break;
                }
                List<String> childBagSplit = Arrays.asList(childBagWithCount.split("(?<=\\d)(?=\\D)"));
                childBags.put(childBagSplit.get(1).trim(), Integer.parseInt(childBagSplit.get(0).trim()));
            }

            Bag bag = new Bag(bagName, childBags);
            bagsByName.put(bagName, bag);
        }

        return bagsByName;
    }
}

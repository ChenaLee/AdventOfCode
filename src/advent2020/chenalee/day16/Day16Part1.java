package advent2020.chenalee.day16;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day16Part1 {
    private static final RuleParser ruleParser = new RuleParser();
    private static final TicketParser ticketParser = new TicketParser();

    public static void main(String[] args) throws IOException {
        Scanner scanner = TestDataReader.getScannerForFile("day16.txt", "\\n\\s*\\n");

        List<Rule> rules = ruleParser.parse(scanner.next());

        String yourTicket = scanner.next();
        String nearByTickestText = scanner.next().split("\\n", 2)[1];

        List<List<Integer>> tickets = ticketParser.parse(nearByTickestText);

        List<Integer> invalidValues = new ArrayList<>();
        for (List<Integer> ticket : tickets) {
            for (int ticketField : ticket) {
                boolean fieldValid = false;
                for (Rule rule : rules) {
                    if (rule.validate(ticketField)) {
                        fieldValid = true;
                        break;
                    }
                }
                if (!fieldValid) {
                    invalidValues.add(ticketField);
                }
            }
        }

        System.out.println(invalidValues.stream().reduce(0, Integer::sum));
    }
}

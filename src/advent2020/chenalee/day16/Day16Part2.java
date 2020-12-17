package advent2020.chenalee.day16;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day16Part2 {
    private static final RuleParser ruleParser = new RuleParser();
    private static final TicketParser ticketParser = new TicketParser();
    private static final TicketValidator ticketValidator = new TicketValidator();

    public static void main(String[] args) throws IOException {
        Scanner scanner = TestDataReader.getScannerForFile("day16.txt", "\\n\\s*\\n");

        List<Rule> rules = ruleParser.parse(scanner.next());

        List<Integer> yourTicket = ticketParser.parse(scanner.next().split("\\n", 2)[1]).get(0);
        String nearByTickestText = scanner.next().split("\\n", 2)[1];

        List<List<Integer>> tickets = ticketParser.parse(nearByTickestText);

        List<List<Integer>> validTickets = tickets.stream()
                .filter(ticket -> ticketValidator.isValid(ticket, rules))
                .collect(Collectors.toList());

        List<Integer> allPossiblePositions = IntStream.range(0, rules.size()).boxed().collect(Collectors.toList());
        Map<String, List<Integer>> fieldToPossiblePositions = new HashMap<>();
        List<String> fieldWithFoundPosition = new ArrayList<>();
        for (Rule rule : rules) {
            fieldToPossiblePositions.put(rule.getName(), new ArrayList<>(allPossiblePositions));
        }

        for (List<Integer> ticket : validTickets) {
            for (int position = 0; position < ticket.size(); position++) {
                for (Rule rule : rules) {
                    if (rule.validate(ticket.get(position))) {
                        continue;
                    }
                    if (!fieldToPossiblePositions.get(rule.getName()).contains(position)) {
                        continue;
                    }
                    fieldToPossiblePositions.get(rule.getName()).remove(Integer.valueOf(position));
                    if (fieldToPossiblePositions.get(rule.getName()).size() == 1) {
                        fieldWithFoundPosition.add(rule.getName());
                    }
                }
            }
        }

        while (fieldWithFoundPosition.size() != rules.size()) {
            for (String name : fieldWithFoundPosition) {
                int reservedPosition = fieldToPossiblePositions.get(name).get(0);
                for (Rule otherRule : rules) {
                    if (otherRule.getName().equals(name)) {
                        continue;
                    }
                    if (!fieldToPossiblePositions.get(otherRule.getName()).contains(reservedPosition)) {
                        continue;
                    }
                    fieldToPossiblePositions.get(otherRule.getName()).remove(Integer.valueOf(reservedPosition));

                }
            }

            for (String name : fieldToPossiblePositions.keySet()) {
                if (fieldToPossiblePositions.get(name).size() == 1 && !fieldWithFoundPosition.contains(name)) {
                    fieldWithFoundPosition.add(name);
                }
            }
        }

        long result = 1;
        for (Rule rule : rules) {
            if (!rule.getName().startsWith("departure")) {
                continue;
            }

            result = result * yourTicket.get(fieldToPossiblePositions.get(rule.getName()).get(0));
        }

        System.out.println(result);
    }
}

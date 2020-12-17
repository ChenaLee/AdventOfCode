package advent2020.chenalee.day16;

import java.util.List;

public class TicketValidator {
    public boolean isValid(List<Integer> ticket, List<Rule> rules) {
        for (int ticketField : ticket) {
            boolean fieldValid = false;
            for (Rule rule : rules) {
                if (rule.validate(ticketField)) {
                    fieldValid = true;
                    break;
                }
            }
            if (!fieldValid) {
                return false;
            }
        }
        return true;
    }
}

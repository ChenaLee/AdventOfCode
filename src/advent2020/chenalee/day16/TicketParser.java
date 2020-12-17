package advent2020.chenalee.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TicketParser {
    public List<List<Integer>> parse(String ticketsText) {
        List<List<Integer>> tickets = new ArrayList<>();
        String[] ticketTextList = ticketsText.split("\\n");
        for (String ticketText : ticketTextList) {
            tickets.add(Arrays.asList(ticketText.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        return tickets;
    }
}

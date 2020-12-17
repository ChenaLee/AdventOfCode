package advent2020.chenalee.day16;

import java.util.ArrayList;
import java.util.List;

public class RuleParser {
    public List<Rule> parse(String rulesText) {
        List<Rule> rules = new ArrayList<>();
        String[] ruleTextList = rulesText.split("\\n");
        for (String ruleText : ruleTextList) {
            String[] ruleSplit = ruleText.split("(:\\s|\\sor\\s)");
            String ruleName = ruleSplit[0];

            List<Range> ranges = new ArrayList<>();
            for (int i = 1; i < ruleSplit.length; i++) {
                String[] rangeSplit = ruleSplit[i].split("-");
                ranges.add(new Range(Integer.parseInt(rangeSplit[0]), Integer.parseInt(rangeSplit[1])));
            }
            rules.add(new Rule(ruleName, new RangeSet(ranges)));
        }

        return rules;
    }
}

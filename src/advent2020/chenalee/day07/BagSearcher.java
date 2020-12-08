package advent2020.chenalee.day07;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.stream.Collectors;

class BagSearcher {
    private final Map<String, Bag> bagsByName;
    private Map<String, Integer> bagMap;

    BagSearcher(Map<String, Bag> bagsByName) {
        this.bagsByName = bagsByName;
        this.bagMap = bagsByName.keySet().stream().collect(Collectors.toMap(e -> e, e -> -1));
    }

    int countAllBagContaining(String bagNameToFind) {
        int count = 0;
        for (String bagName : bagsByName.keySet()) {
            if (searchBag(bagName, bagNameToFind) > 0) {
                count++;
            }
        }
        return count;
    }

    int countBags(String bagName) {
        // if this bag was already searched, return that value
        Bag bag = bagsByName.get(bagName);
        int bagValue = bagMap.get(bagName);
        if (bagValue != -1) {
            return bagValue;
        }
        // if leaf node, return 1
        if (bag.getChildrenBagsWithCount().isEmpty()) {
            bagMap.replace(bagName, 1);
            return 1;
        }
        // else, for each child node
        Map<String, Integer> childrenBagsWithCount = bag.getChildrenBagsWithCount();
        int foundBagCount = 0;
        for (String childBagName : childrenBagsWithCount.keySet()) {
            foundBagCount += countBags(childBagName) * childrenBagsWithCount.get(childBagName);
        }
        foundBagCount += 1; // the current bag itself
        bagMap.replace(bagName, foundBagCount);
        return foundBagCount;
    }

    private int searchBag(String bagName, String bagNameToFind) {
        // if this bag was already searched, return that value
        Bag bag = bagsByName.get(bagName);
        int bagValue = bagMap.get(bagName);
        if (bagValue != -1) {
            return bagValue;
        }
        // if this is the bag I'm looking for, no need to search children
        if (bag.getName().equals(bagNameToFind)) {
            bagMap.replace(bagName, 1);
            return 1;
        }
        // if other leaf node, return 0
        if (bag.getChildrenBagsWithCount().isEmpty()) {
            bagMap.replace(bagName, 0);
            return 0;
        }
        // else, for each child node
        Map<String, Integer> childrenBagsWithCount = bag.getChildrenBagsWithCount();
        int foundBagCount = 0;
        for (String childBagName : childrenBagsWithCount.keySet()) {
            foundBagCount += searchBag(childBagName, bagNameToFind) * childrenBagsWithCount.get(childBagName);
        }
        bagMap.replace(bagName, foundBagCount);
        return foundBagCount;
    }
}
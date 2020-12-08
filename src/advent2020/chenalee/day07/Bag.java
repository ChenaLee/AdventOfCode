package advent2020.chenalee.day07;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
class Bag {
    private final String name;
    private final Map<String, Integer> childrenBagsWithCount;
}

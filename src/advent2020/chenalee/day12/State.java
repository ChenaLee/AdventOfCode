package advent2020.chenalee.day12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class State {
    private final int xPos;
    private final int yPos;
    private final String facingDirection;
    private int shipXPos;
    private int shipYPos;
}

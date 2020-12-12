package advent2020.chenalee.day12.processor.waypointProcessor;

import advent2020.chenalee.day12.DirectionDegreeMapper;
import advent2020.chenalee.day12.State;

public class VectorRotator {
    public State rotate(State startState, int degreeToRotate) {
        int positiveDegreeIn360Range = ((degreeToRotate % 360) + 360) % 360;
        if (positiveDegreeIn360Range == 0) {
            return startState;
        } else if (positiveDegreeIn360Range == 90) {
            return new State(startState.getYPos(), -startState.getXPos(), startState.getFacingDirection(),
                    startState.getShipXPos(), startState.getShipYPos());
        } else if (positiveDegreeIn360Range == 180) {
            return new State(-startState.getXPos(), -startState.getYPos(), startState.getFacingDirection(),
                    startState.getShipXPos(), startState.getShipYPos());
        } else if (positiveDegreeIn360Range == 270) {
            return new State(-startState.getYPos(), startState.getXPos(), startState.getFacingDirection(),
                    startState.getShipXPos(), startState.getShipYPos());
        } else {
            throw new RuntimeException();
        }
    }
}

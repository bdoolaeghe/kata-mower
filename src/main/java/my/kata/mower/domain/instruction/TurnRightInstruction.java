package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.geography.orientation.Orientation;
import my.kata.mower.domain.lawn.Lawn;

public class TurnRightInstruction implements Instruction {

    @Override
    public Orientation applyOn(Orientation currentOrientation) {
        return currentOrientation.turnRight();
    }

    @Override
    public Coordinates applyOn(Coordinates currentPosition, Orientation currentOrientation, Lawn lawn) {
        return currentPosition;
    }
}

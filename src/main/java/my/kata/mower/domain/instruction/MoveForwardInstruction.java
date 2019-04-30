package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.geography.orientation.Orientation;
import my.kata.mower.domain.lawn.Lawn;

public class MoveForwardInstruction implements Instruction {

    private Coordinates checkedNewPosition(Coordinates newPosition, Coordinates currentPosition, Lawn lawn) {
        if (lawn.contains(newPosition)) {
            return newPosition;
        } else {
            // oops, instruction make me go out of the lawn
            return currentPosition;
        }
    }

    @Override
    public Orientation applyOn(Orientation currentOrientation) {
        return currentOrientation;
    }

    @Override
    public Coordinates applyOn(Coordinates currentPosition, Orientation currentOrientation, Lawn lawn) {
        Coordinates newPosition = null;
        switch (currentOrientation) {
            case NORTH:
                newPosition = currentPosition.up();
                break;
            case SOUTH:
                newPosition = currentPosition.down();
                break;
            case EAST:
                newPosition = currentPosition.right();
                break;
            case WEST:
                newPosition = currentPosition.left();
                break;
        }

        return checkedNewPosition(newPosition, currentPosition, lawn);
    }
}

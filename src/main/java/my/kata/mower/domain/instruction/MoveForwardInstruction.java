package my.kata.mower.domain.instruction;

import lombok.EqualsAndHashCode;
import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.geography.orientation.Orientation;
import my.kata.mower.domain.lawn.Lawn;

@EqualsAndHashCode
public class MoveForwardInstruction implements Instruction {

    private Coordinates checkedNewPosition(Coordinates newPosition, Coordinates currentPosition, Lawn lawn) {
        return lawn.contains(newPosition)
                ? newPosition
                : currentPosition; // oops, instruction make me go out of the lawn
    }

    @Override
    public Orientation applyOn(Orientation currentOrientation) {
        return currentOrientation;
    }

    @Override
    public Coordinates applyOn(Coordinates currentPosition, Orientation currentOrientation, Lawn lawn) {
        var newPosition = computeNewPosition(currentPosition, currentOrientation);
        return checkedNewPosition(newPosition, currentPosition, lawn);
    }

    private static Coordinates computeNewPosition(Coordinates currentPosition, Orientation currentOrientation) {
        return switch (currentOrientation) {
            case NORTH -> currentPosition.onTop();
            case SOUTH -> currentPosition.onBottom();
            case EAST -> currentPosition.atRight();
            case WEST -> currentPosition.atLeft();
        };
    }
}

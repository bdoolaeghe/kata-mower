package my.kata.mower.domain.instruction;

import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.coordinates.Coordinates;
import my.kata.mower.domain.orientation.Orientation;

public class ForwardInstruction implements Instruction {

    @Override
    public Coordinates applyOn(Coordinates oldPosition, Orientation orientation, Lawn lawn) {
        //FIXME not cute, refactor ifs
        Coordinates newPosition = null;
        if (orientation == Orientation.NORTH) {
            newPosition = oldPosition.up();
        }
        if (orientation == Orientation.WEST) {
            newPosition = oldPosition.left();
        }
        if (orientation == Orientation.SOUTH) {
            newPosition = oldPosition.down();
        }
        if (orientation == Orientation.EAST) {
            newPosition = oldPosition.right();
        }

        if (newPosition == null) {
            throw  new UnsupportedOperationException("Unknown orientation: " + orientation.getClass().getName());
        }

        if (lawn.contains(newPosition)) {
            return newPosition;
        } else {
            // oops, instruction make me go out of the lawn
            return oldPosition;
        }
    }

}

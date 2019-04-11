package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.geography.orientation.Orientation;

import static my.kata.mower.domain.geography.orientation.Orientation.*;

public class ForwardInstructionProcessor implements Applyable {

    @Override
    public Coordinates applyOn(Coordinates oldPosition, Orientation orientation, Lawn lawn) {
        //FIXME not cute, refactor ifs
        Coordinates newPosition = null;
        if (orientation == NORTH) {
            newPosition = oldPosition.up();
        }
        if (orientation == WEST) {
            newPosition = oldPosition.left();
        }
        if (orientation == SOUTH) {
            newPosition = oldPosition.down();
        }
        if (orientation == EAST) {
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

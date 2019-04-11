package my.kata.mower.domain.instruction;

import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.coordinates.Coordinates;
import my.kata.mower.domain.orientation.Orientation;

public interface InstructionProcessor {

    default Coordinates processOn(Coordinates oldPosition, Orientation orientation, Lawn lawn) {
        return oldPosition;
    }
    default Orientation processOn(Orientation oldOrientation) {
        return oldOrientation;
    }

}

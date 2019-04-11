package my.kata.mower.domain.instruction;

import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.geography.orientation.Orientation;

public interface Applyable {

    default Coordinates applyOn(Coordinates oldPosition, Orientation orientation, Lawn lawn) {
        return oldPosition;
    }
    default Orientation applyOn(Orientation oldOrientation) {
        return oldOrientation;
    }

}

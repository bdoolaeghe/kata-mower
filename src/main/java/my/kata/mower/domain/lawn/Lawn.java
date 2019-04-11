package my.kata.mower.domain.lawn;

import my.kata.mower.domain.coordinates.Coordinates;
import lombok.Getter;

@Getter
public class Lawn {

    private final Coordinates upperRightCorner;

    public Lawn(Coordinates upperRightCorner) {
        this.upperRightCorner = upperRightCorner;
    }

    public boolean contains(Coordinates coord) {
        return coord.getX().getValue() <= upperRightCorner.getX().getValue() &&
                coord.getY().getValue() <= upperRightCorner.getY().getValue();
    }
}

package my.kata.mower.domain.lawn;

import my.kata.mower.domain.geography.coordinates.Coordinates;
import lombok.Getter;

@Getter
public class Lawn {

    private final Coordinates upperRightCorner;

    public Lawn(Coordinates upperRightCorner) {
        this.upperRightCorner = upperRightCorner;
    }

    public boolean contains(Coordinates coord) {
        return upperRightCorner.isGreaterThan(coord);
    }
}

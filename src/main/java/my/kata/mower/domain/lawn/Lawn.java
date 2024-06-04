package my.kata.mower.domain.lawn;

import my.kata.mower.domain.geography.coordinates.Coordinates;

public record Lawn(Coordinates upperRightCorner) {

    public boolean contains(Coordinates coord) {
        return upperRightCorner.isGreaterThan(coord) && coord.isPositive();
    }
}

package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.orientation.Orientation;

import static my.kata.mower.domain.geography.orientation.Orientation.*;

public class FromNorthTurner implements Turnable {
    @Override
    public Orientation turnLeft() {
        return WEST;
    }

    @Override
    public Orientation turnRight() {
        return EAST;
    }


    @Override
    public String toString() {
        return NORTH.code;
    }
}

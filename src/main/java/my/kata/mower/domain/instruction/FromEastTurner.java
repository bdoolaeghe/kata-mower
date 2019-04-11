package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.orientation.Orientation;
import my.kata.mower.domain.instruction.Turnable;

import static my.kata.mower.domain.geography.orientation.Orientation.*;

public class FromEastTurner implements Turnable {

    @Override
    public Orientation turnLeft() {
        return NORTH;
    }

    @Override
    public Orientation turnRight() {
        return SOUTH;
    }

    @Override
    public String toString() {
        return EAST.code;
    }
}

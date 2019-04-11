package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.orientation.Orientation;
import my.kata.mower.domain.instruction.Turnable;

import static my.kata.mower.domain.geography.orientation.Orientation.*;

public class FromWestTurner implements Turnable {

    @Override
    public Orientation turnLeft() {
        return SOUTH;
    }

    @Override
    public Orientation turnRight() {
        return NORTH;
    }


    @Override
    public String toString() {
        return WEST.code;
    }

}

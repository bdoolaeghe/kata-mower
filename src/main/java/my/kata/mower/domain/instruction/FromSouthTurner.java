package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.orientation.Orientation;
import my.kata.mower.domain.instruction.Turnable;

import static my.kata.mower.domain.geography.orientation.Orientation.*;

public class FromSouthTurner implements Turnable {

    @Override
    public Orientation turnLeft() {
        return EAST;
    }

    @Override
    public Orientation turnRight() {
        return WEST;
    }


    @Override
    public String toString() {
        return SOUTH.code;
    }

}

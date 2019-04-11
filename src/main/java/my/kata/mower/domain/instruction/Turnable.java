package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.orientation.Orientation;

public interface Turnable {

    Orientation turnLeft();
    Orientation turnRight();

}

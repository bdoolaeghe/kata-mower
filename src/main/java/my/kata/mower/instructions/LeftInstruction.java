package my.kata.mower.instructions;

import my.kata.mower.orientation.Orientation;

public class LeftInstruction implements Instruction {

    @Override
    public Orientation applyOn(Orientation oldOrientation) {
        return oldOrientation.turnLeft();
    }
}

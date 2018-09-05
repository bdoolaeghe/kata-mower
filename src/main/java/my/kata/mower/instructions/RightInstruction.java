package my.kata.mower.instructions;

import my.kata.mower.orientation.Orientation;

public class RightInstruction implements Instruction {

    @Override
    public Orientation applyOn(Orientation oldOrientation) {
        return oldOrientation.turnRight();
    }
}

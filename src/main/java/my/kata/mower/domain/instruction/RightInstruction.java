package my.kata.mower.domain.instruction;

import my.kata.mower.domain.orientation.Orientation;

public class RightInstruction implements Instruction {

    @Override
    public Orientation applyOn(Orientation oldOrientation) {
        return oldOrientation.turnRight();
    }
}

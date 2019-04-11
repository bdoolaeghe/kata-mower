package my.kata.mower.domain.instruction;

import my.kata.mower.domain.orientation.Orientation;

public class RightInstructionProcessor implements InstructionProcessor {

    @Override
    public Orientation processOn(Orientation oldOrientation) {
        return oldOrientation.turnRight();
    }
}

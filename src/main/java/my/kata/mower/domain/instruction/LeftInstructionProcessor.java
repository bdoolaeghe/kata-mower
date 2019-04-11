package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.orientation.Orientation;

public class LeftInstructionProcessor implements Applyable {

    @Override
    public Orientation applyOn(Orientation oldOrientation) {
        return oldOrientation.turnLeft();
    }

}

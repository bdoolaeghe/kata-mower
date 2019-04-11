package my.kata.mower.domain.instruction;

import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.coordinates.Coordinates;
import my.kata.mower.domain.orientation.Orientation;

public interface Instruction {
    Instruction LEFT = new LeftInstruction();
    Instruction RIGHT = new RightInstruction();
    Instruction FORWARD = new ForwardInstruction();

    default Coordinates applyOn(Coordinates oldPosition, Orientation orientation, Lawn lawn) {
        return oldPosition;
    }
    default Orientation applyOn(Orientation oldOrientation) {
        return oldOrientation;
    }

    static Instruction parse(String instruction) {
        //FIXME maybe we could do something nicer
        if ("L".equals(instruction.toUpperCase().trim())) {
            return LEFT;
        }
        if ("R".equals(instruction.toUpperCase().trim())) {
            return RIGHT;
        }
        if ("F".equals(instruction.toUpperCase().trim())) {
            return FORWARD;
        }

        throw new IllegalArgumentException("unsupported instruction: " + instruction);
    }
}

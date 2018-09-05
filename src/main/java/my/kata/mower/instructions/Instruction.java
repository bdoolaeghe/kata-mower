package my.kata.mower.instructions;

import my.kata.mower.Lawn;
import my.kata.mower.coordinates.Coordinates;
import my.kata.mower.orientation.Orientation;

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

package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.geography.orientation.Orientation;

public interface Instruction {

    static Instruction fromCode(String aLetterCode) {
        switch (aLetterCode) {
            case "L":
                return new TurnLeftInstruction();
            case "R":
                return new TurnRightInstruction();
            case "F":
                return new MoveForwardInstruction();
            default:
                throw new IllegalArgumentException("Unsupported instruction \"" + aLetterCode + "\"");
        }
    }

    Orientation applyOn(Orientation currentOrientation);

    Coordinates applyOn(Coordinates currentPosition, Orientation currentOrientation, Lawn lawn);
}

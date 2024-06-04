package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.geography.orientation.Orientation;
import my.kata.mower.domain.lawn.Lawn;

import static java.text.MessageFormat.format;

public interface Instruction {

    static Instruction fromCode(String aLetterCode) {
        return switch (aLetterCode) {
            case "L" -> new TurnLeftInstruction();
            case "R" -> new TurnRightInstruction();
            case "F" -> new MoveForwardInstruction();
            default -> throw new IllegalArgumentException(format("Unsupported instruction \"{0}\"", aLetterCode));
        };
    }

    Orientation applyOn(Orientation currentOrientation);

    Coordinates applyOn(Coordinates currentPosition, Orientation currentOrientation, Lawn lawn);
}

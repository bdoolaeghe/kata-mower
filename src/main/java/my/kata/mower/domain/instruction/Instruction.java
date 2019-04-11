package my.kata.mower.domain.instruction;

import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.geography.orientation.Orientation;

public enum Instruction implements Applyable {

    LEFT("L", new LeftInstructionProcessor()),
    RIGHT("R", new RightInstructionProcessor()),
    FORWARD("F", new ForwardInstructionProcessor());

    final Applyable processor;
    final String code;

    Instruction(String code, Applyable processor) {
        this.code = code;
        this.processor = processor;
    }

    public static Instruction fromLetter(String aLetterCode) {
        for(Instruction value : values()) {
            if (value.code.equals(aLetterCode.toUpperCase().trim()))
                return value;
        }
        throw new IllegalArgumentException("Unsupported instruction \"" + aLetterCode + "\"");
    }


    @Override
    public Coordinates applyOn(Coordinates oldPosition, Orientation orientation, Lawn lawn) {
        return processor.applyOn(oldPosition, orientation, lawn);
    }

    @Override
    public Orientation applyOn(Orientation oldOrientation) {
        return processor.applyOn(oldOrientation);
    }
}

package my.kata.mower.domain.geography.orientation;

import my.kata.mower.domain.instruction.*;

public enum Orientation implements Turnable {

    NORTH("N",  new FromNorthTurner()),
    SOUTH("S", new FromSouthTurner()),
    EAST("E", new FromEastTurner()),
    WEST("W", new FromWestTurner());

    public final String code;

    public final Turnable turnInstructionProcessor;

    Orientation(String code, Turnable turnInstructionProcessor) {
        this.code = code;
        this.turnInstructionProcessor = turnInstructionProcessor;
    }

    public static Orientation fromLetter(String aLetterCode) {
        for(Orientation value : values()) {
            if (value.code.equals(aLetterCode.toUpperCase().trim()))
                return value;
        }
        throw new IllegalArgumentException("Unsupported orientation \"" + aLetterCode + "\"");
    }

    @Override
    public Orientation turnLeft() {
        return turnInstructionProcessor.turnLeft();
    }

    @Override
    public Orientation turnRight() {
        return turnInstructionProcessor.turnRight();
    }

    @Override
    public String toString() {
        return code;
    }
}

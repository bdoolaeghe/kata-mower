package my.kata.mower.domain.geography.orientation;

import static java.text.MessageFormat.format;

public enum Orientation {

    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    public final String code;

    Orientation(String code) {
        this.code = code;
    }

    public Orientation turnLeft() {
        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
        };
    }

    public Orientation turnRight() {
        return switch (this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
        };
    }

    public static Orientation fromLetter(String aLetterCode) {
        for(var value : values()) {
            if (value.code.equals(aLetterCode.toUpperCase().trim()))
                return value;
        }
        throw new IllegalArgumentException(format("Unsupported orientation \"{0}\"", aLetterCode));
    }

    @Override
    public String toString() {
        return code;
    }
}

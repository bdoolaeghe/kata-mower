package my.kata.mower.domain.geography.orientation;

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
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
        }
        throw new UnsupportedOperationException();
    }

    public Orientation turnRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
        }
        throw new UnsupportedOperationException();
    }

    public static Orientation fromLetter(String aLetterCode) {
        for(Orientation value : values()) {
            if (value.code.equals(aLetterCode.toUpperCase().trim()))
                return value;
        }
        throw new IllegalArgumentException("Unsupported orientation \"" + aLetterCode + "\"");
    }

    @Override
    public String toString() {
        return code;
    }
}

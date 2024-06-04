package my.kata.mower.domain.geography.coordinates;


import static java.lang.Integer.parseInt;

public record Y(int ordinate) {

    public Y shiftUp() {
        return y(this.ordinate + 1);
    }

    public Y shiftDown() {
        return y(this.ordinate - 1);
    }

    public boolean isGreaterThan(Y otherY) {
        return this.ordinate >= otherY.ordinate;
    }

    public boolean isPositive() {
        return ordinate >= 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.ordinate);
    }

    public static Y y(int value) {
        return new Y(value);
    }

    public static Y y(String value) {
        return new Y(parseInt(value));
    }

}

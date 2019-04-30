package my.kata.mower.domain.geography.coordinates;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Y {

    private int ordinate;

    public Y(int ordinate) {
        this.ordinate = ordinate;
    }


    public Y shiftUp() {
        return y(this.ordinate + 1);
    }

    public Y shifDown() {
        return y(this.ordinate - 1);
    }

    public boolean isGreaterThan(Y otherY) {
        return this.ordinate >= otherY.ordinate;
    }

    @Override
    public String toString() {
        return "" + this.ordinate;
    }

    public static Y y(int value) {
        return new Y(value);
    }

    public static Y y(String value) {
        return new Y(Integer.parseInt(value));
    }

    public boolean isPositive() {
        return ordinate >= 0;
    }
}

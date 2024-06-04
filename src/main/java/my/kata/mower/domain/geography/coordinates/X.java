package my.kata.mower.domain.geography.coordinates;


import static java.lang.Integer.parseInt;

public record X(int abscissa) {

    public X shiftRight() {
        return x(this.abscissa + 1);
    }

    public X shiftLeft() {
        return x(this.abscissa - 1);
    }

    public boolean isGreaterThan(X otherX) {
        return this.abscissa >= otherX.abscissa;
    }

    public boolean isPositive() {
        return abscissa >= 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.abscissa);
    }

    public static X x(int value) {
        return new X(value);
    }

    public static X x(String value) {
        return new X(parseInt(value));
    }

}

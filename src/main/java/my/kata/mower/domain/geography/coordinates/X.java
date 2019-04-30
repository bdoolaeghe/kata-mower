package my.kata.mower.domain.geography.coordinates;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class X {

    private int abscissa;

    public X(int abscissa) {
        this.abscissa = abscissa;
    }

    public X shiftRight() {
        return x(this.abscissa + 1);
    }

    public X shiftLeft() {
        return x(this.abscissa - 1);
    }

    public boolean isGreaterThan(X otherX) {
        return this.abscissa >= otherX.abscissa;
    }

    @Override
    public String toString() {
        return "" + this.abscissa;
    }

    public static X x(int value) {
        return new X(value);
    }

    public static X x(String value) {
        return new X(Integer.parseInt(value));
    }
}

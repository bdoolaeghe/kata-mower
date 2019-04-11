package my.kata.mower.domain.geography.coordinates;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class X extends Coordinate {
    public X(int value) {
        super(value);
    }

    public static X x(int value) {
        return new X(value);
    }

    public static X x(String value) {
        return new X(Integer.parseInt(value));
    }
}

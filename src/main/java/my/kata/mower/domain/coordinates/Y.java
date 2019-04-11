package my.kata.mower.domain.coordinates;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Y extends Coordinate {
    public Y(int value) {
        super(value);
    }
    public static Y y(int value) {
        return new Y(value);
    }

    public static Y y(String value) {
        return new Y(Integer.parseInt(value));
    }


}

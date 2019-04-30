package my.kata.mower.domain.geography.coordinates;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import static my.kata.mower.domain.geography.coordinates.X.x;
import static my.kata.mower.domain.geography.coordinates.Y.y;

@AllArgsConstructor
@EqualsAndHashCode
public class Coordinates {

    @NonNull
    private X x;

    @NonNull
    private Y y;

    public Coordinates right() {
        return coordinates(x.shiftRight(), y);
    }

    public Coordinates left() {
        return coordinates(x.shiftLeft(), y);
    }

    public Coordinates up() {
        return coordinates(x, y.shiftUp());
    }

    public Coordinates down() {
        return coordinates(x, y.shifDown());
    }

    public boolean isGreaterThan(Coordinates otherCoordinates) {
        return this.x.isGreaterThan(otherCoordinates.x) &&
                this.y.isGreaterThan(otherCoordinates.y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public static Coordinates coordinates(X x, Y y) {
        return new Coordinates(x, y);
    }
}

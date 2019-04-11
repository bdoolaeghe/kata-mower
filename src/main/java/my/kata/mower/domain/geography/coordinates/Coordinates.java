package my.kata.mower.domain.geography.coordinates;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import static my.kata.mower.domain.geography.coordinates.X.x;
import static my.kata.mower.domain.geography.coordinates.Y.y;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Coordinates {

    @NonNull
    private X x;

    @NonNull
    private Y y;

    public Coordinates right() {
        return coordinates(x(this.x.getValue() + 1), y);
    }

    public Coordinates left() {
        return coordinates(x(this.x.getValue() - 1), y);
    }

    public Coordinates up() {
        return coordinates(x, y(this.y.getValue() + 1));
    }

    public Coordinates down() {
        return coordinates(x, y(this.y.getValue() - 1));
    }

    @Override
    public String toString() {
        return "(" + x.getValue() + "," + y.getValue() + ")";
    }

    public static Coordinates coordinates(X x, Y y) {
        return new Coordinates(x, y);
    }
}

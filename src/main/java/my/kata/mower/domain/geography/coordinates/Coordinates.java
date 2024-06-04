package my.kata.mower.domain.geography.coordinates;


import static java.text.MessageFormat.format;

public record Coordinates(X x, Y y) {;

    public Coordinates atRight() {
        return coordinates(x.shiftRight(), y);
    }

    public Coordinates atLeft() {
        return coordinates(x.shiftLeft(), y);
    }

    public Coordinates onTop() {
        return coordinates(x, y.shiftUp());
    }

    public Coordinates onBottom() {
        return coordinates(x, y.shiftDown());
    }

    public boolean isGreaterThan(Coordinates otherCoordinates) {
        return this.x.isGreaterThan(otherCoordinates.x) &&
               this.y.isGreaterThan(otherCoordinates.y);
    }

    public boolean isPositive() {
        return x.isPositive() && y.isPositive();
    }

    @Override
    public String toString() {
        return format("({0},{1})", x, y);
    }

    public static Coordinates coordinates(X x, Y y) {
        return new Coordinates(x, y);
    }
}

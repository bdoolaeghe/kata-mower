package my.kata.mower.orientation;

public class EastOrientation implements Orientation {

    @Override
    public Orientation turnLeft() {
        return NORTH;
    }

    @Override
    public Orientation turnRight() {
        return SOUTH;
    }

    @Override
    public String toString() {
        return "E";
    }
}

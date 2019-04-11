package my.kata.mower.domain.orientation;

public class NorthOrientation implements Orientation {
    @Override
    public Orientation turnLeft() {
        return WEST;
    }

    @Override
    public Orientation turnRight() {
        return EAST;
    }


    @Override
    public String toString() {
        return "N";
    }
}

package my.kata.mower.domain.orientation;

public class SouthOrientation implements Orientation {

    @Override
    public Orientation turnLeft() {
        return EAST;
    }

    @Override
    public Orientation turnRight() {
        return WEST;
    }


    @Override
    public String toString() {
        return "S";
    }

}

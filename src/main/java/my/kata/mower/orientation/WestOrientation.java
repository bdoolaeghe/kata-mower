package my.kata.mower.orientation;

public class WestOrientation implements Orientation {

    @Override
    public Orientation turnLeft() {
        return SOUTH;
    }

    @Override
    public Orientation turnRight() {
        return NORTH;
    }


    @Override
    public String toString() {
        return "W";
    }

}

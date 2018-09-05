package my.kata.mower.orientation;

public interface Orientation {

    Orientation NORTH = new NorthOrientation();
    Orientation SOUTH = new SouthOrientation();
    Orientation EAST= new EastOrientation();
    Orientation WEST= new WestOrientation();

    Orientation turnLeft();
    Orientation turnRight();

    static Orientation parse(String orientation) {
        //FIXME maybe we could do something nicer
        if ("N".equals(orientation.toUpperCase().trim())) {
            return NORTH;
        }
        if ("S".equals(orientation.toUpperCase().trim())) {
            return SOUTH;
        }
        if ("E".equals(orientation.toUpperCase().trim())) {
            return EAST;
        }
        if ("W".equals(orientation.toUpperCase().trim())) {
            return WEST;
        }

        throw new IllegalArgumentException("unsupported orientation: " + orientation);
    }

}

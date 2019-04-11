package my.kata.mower.coordinates;

import lombok.Getter;

@Getter
public abstract class Coordinate {

    private int value;

    public Coordinate(int value) {
        this.value = value;
    }

}

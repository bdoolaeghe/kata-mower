package my.kata.mower.coordinates;

import lombok.Getter;

@Getter
public abstract class XY {

    private int value;

    public XY(int value) {
        this.value = value;
    }

}

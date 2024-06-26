package my.kata.mower.domain.geography.coordinates;

import org.junit.jupiter.api.Test;

import static my.kata.mower.domain.geography.coordinates.Coordinates.coordinates;
import static my.kata.mower.domain.geography.coordinates.X.x;
import static my.kata.mower.domain.geography.coordinates.Y.y;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordinatesTest {

    @Test
    public void isGreaterThan_should_compare_far_points() {
        var farPoint = coordinates(x(10), y(20));
        var closePoint = coordinates(x(1), y(2));
        assertTrue(farPoint.isGreaterThan(closePoint));
    }

    @Test
    public void isGreaterThan_should_compare_close_points() {
        var farPoint = coordinates(x(10), y(20));
        var justDownPoint = coordinates(x(10), y(19));
        assertTrue(farPoint.isGreaterThan(justDownPoint));

        var justLeftPoint = coordinates(x(9), y(20));
        assertTrue(farPoint.isGreaterThan(justLeftPoint));

        var samePoint = coordinates(x(10), y(20));
        assertTrue(farPoint.isGreaterThan(samePoint));
    }
}

package my.kata.mower;

import my.kata.mower.domain.instruction.Instruction;
import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.mower.Mower;
import org.junit.jupiter.api.Test;

import static my.kata.mower.domain.geography.coordinates.Coordinates.coordinates;
import static my.kata.mower.domain.geography.coordinates.X.x;
import static my.kata.mower.domain.geography.coordinates.Y.y;
import static my.kata.mower.domain.geography.orientation.Orientation.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MowerTest {

    Lawn lawn = new Lawn(coordinates(x(2), y(3)));

    @Test
    public void shloud_compute_new_position_when_going_north() {
        Mower mower = new Mower(coordinates(x(0), y(0)), NORTH);
        mower.execute(Instruction.fromCode("F"), lawn);
        assertThat(mower.getPosition()).isEqualTo(coordinates(x(0), y(1)));
        assertThat(mower.getOrientation()).isEqualTo(NORTH);
    }

    @Test
    public void shloud_stay_when_trying_to_go_north_out_of_lawn() {
        Mower mower = new Mower(coordinates(x(0), y(3)), NORTH);
        mower.execute(Instruction.fromCode("F"), lawn);
        assertThat(mower.getPosition()).isEqualTo(coordinates(x(0), y(3)));
        assertThat(mower.getOrientation()).isEqualTo(NORTH);
    }

    @Test
    public void shloud_compute_new_position_when_going_south() {
        Mower mower = new Mower(coordinates(x(0), y(1)), SOUTH);
        mower.execute(Instruction.fromCode("F"), lawn);
        assertThat(mower.getPosition()).isEqualTo(coordinates(x(0), y(0)));
        assertThat(mower.getOrientation()).isEqualTo(SOUTH);
    }

    @Test
    public void shloud_stay_when_trying_to_go_south_out_of_lawn() {
        Mower mower = new Mower(coordinates(x(0), y(0)), SOUTH);
        mower.execute(Instruction.fromCode("F"), lawn);
        assertThat(mower.getPosition()).isEqualTo(coordinates(x(0), y(0)));
        assertThat(mower.getOrientation()).isEqualTo(SOUTH);
    }

    @Test
    public void shloud_compute_new_position_when_going_west() {
        Mower mower = new Mower(coordinates(x(1), y(0)), WEST);
        mower.execute(Instruction.fromCode("F"), lawn);
        assertThat(mower.getPosition()).isEqualTo(coordinates(x(0), y(0)));
        assertThat(mower.getOrientation()).isEqualTo(WEST);
    }


    @Test
    public void shloud_stay_when_trying_to_go_west_out_of_lawn() {
        Mower mower = new Mower(coordinates(x(0), y(0)), WEST);
        mower.execute(Instruction.fromCode("F"), lawn);
        assertThat(mower.getPosition()).isEqualTo(coordinates(x(0), y(0)));
        assertThat(mower.getOrientation()).isEqualTo(WEST);
    }

    @Test
    public void shloud_compute_new_position_when_going_east() {
        Mower mower = new Mower(coordinates(x(0), y(0)), EAST);
        mower.execute(Instruction.fromCode("F"), lawn);
        assertThat(mower.getPosition()).isEqualTo(coordinates(x(1), y(0)));
        assertThat(mower.getOrientation()).isEqualTo(EAST);
    }

    @Test
    public void shloud_stay_when_trying_to_go_east_out_of_lawn() {
        Mower mower = new Mower(coordinates(x(2), y(0)), EAST);
        mower.execute(Instruction.fromCode("F"), lawn);
        assertThat(mower.getPosition()).isEqualTo(coordinates(x(2), y(0)));
        assertThat(mower.getOrientation()).isEqualTo(EAST);
    }

    @Test
    public void should_be_oriented_north_when_turn_right_from_west() {
        Mower mower = new Mower(coordinates(x(2), y(0)), WEST);
        mower.execute(Instruction.fromCode("R"), lawn);
        assertThat(mower.getOrientation()).isEqualTo(NORTH);
    }

    @Test
    public void should_be_oriented_east_when_turn_right_from_north() {
        Mower mower = new Mower(coordinates(x(2), y(0)), NORTH);
        mower.execute(Instruction.fromCode("R"), lawn);
        assertThat(mower.getOrientation()).isEqualTo(EAST);
    }

    @Test
    public void should_be_oriented_south_when_turn_right_from_east() {
        Mower mower = new Mower(coordinates(x(2), y(0)), EAST);
        mower.execute(Instruction.fromCode("R"), lawn);
        assertThat(mower.getOrientation()).isEqualTo(SOUTH);
    }

    @Test
    public void should_be_oriented_west_when_turn_right_from_south() {
        Mower mower = new Mower(coordinates(x(2), y(0)), SOUTH);
        mower.execute(Instruction.fromCode("R"), lawn);
        assertThat(mower.getOrientation()).isEqualTo(WEST);
    }

    @Test
    public void should_be_oriented_south_when_turn_left_from_west() {
        Mower mower = new Mower(coordinates(x(2), y(0)), WEST);
        mower.execute(Instruction.fromCode("L"), lawn);
        assertThat(mower.getOrientation()).isEqualTo(SOUTH);
    }
    @Test
    public void should_be_oriented_west_when_turn_left_from_north() {
        Mower mower = new Mower(coordinates(x(2), y(0)), NORTH);
        mower.execute(Instruction.fromCode("L"), lawn);
        assertThat(mower.getOrientation()).isEqualTo(WEST);
    }

    @Test
    public void should_be_oriented_north_when_turn_left_from_east() {
        Mower mower = new Mower(coordinates(x(2), y(0)), EAST);
        mower.execute(Instruction.fromCode("L"), lawn);
        assertThat(mower.getOrientation()).isEqualTo(NORTH);

    }

    @Test
    public void should_be_oriented_east_when_turn_left_from_south() {
        Mower mower = new Mower(coordinates(x(2), y(0)), SOUTH);
        mower.execute(Instruction.fromCode("L"), lawn);
        assertThat(mower.getOrientation()).isEqualTo(EAST);
    }
}

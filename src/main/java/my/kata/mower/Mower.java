package my.kata.mower;

import my.kata.mower.coordinates.Coordinates;
import my.kata.mower.instructions.Instruction;
import my.kata.mower.orientation.Orientation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Getter
@AllArgsConstructor
public class Mower {

    @NonNull
    private Coordinates position;
    @NonNull
    private Orientation orientation;

    public void apply(Instruction instruction, Lawn lawn) {
        orientation = instruction.applyOn(orientation);
        position = instruction.applyOn(position, orientation, lawn);
    }

    public void applyAll(List<Instruction> instructions , Lawn lawn) {
        instructions.forEach(instruction -> apply(instruction, lawn));
    }

    @Override
    public String toString() {
        return position.getX().getValue() + " " + position.getY().getValue() + " " + orientation.toString();
    }
}

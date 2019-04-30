package my.kata.mower.domain.mower;

import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.instruction.Instruction;
import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.geography.orientation.Orientation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

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

    public void applyAll(List<Instruction> instructions, Lawn lawn) {
        instructions.forEach(instruction -> apply(instruction, lawn));
    }

    @Override
    public String toString() {
        return position + " " + orientation;
    }
}

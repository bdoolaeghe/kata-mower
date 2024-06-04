package my.kata.mower.domain.mower;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.geography.orientation.Orientation;
import my.kata.mower.domain.instruction.Instruction;
import my.kata.mower.domain.lawn.Lawn;

import java.util.List;

import static java.text.MessageFormat.format;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Mower {

    @NonNull
    private Coordinates position;
    @NonNull
    private Orientation orientation;

    public Mower execute(Instruction instruction, Lawn lawn) {
        orientation = instruction.applyOn(orientation);
        position = instruction.applyOn(position, orientation, lawn);
        return this;
    }

    public Mower execute(List<Instruction> instructions, Lawn lawn) {
        instructions.forEach(instruction -> execute(instruction, lawn));
        return this;
    }

    @Override
    public String toString() {
        return format("{0} {1}", position, orientation);
    }
}

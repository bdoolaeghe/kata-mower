package my.kata.mower;

import my.kata.mower.coordinates.Coordinates;
import my.kata.mower.instructions.Instruction;
import my.kata.mower.orientation.Orientation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Mower {

    @NonNull
    private Lawn lawn;
    @NonNull
    private Coordinates position;
    @NonNull
    private Orientation orientation;

    public void apply(Instruction instruction) {
        orientation = instruction.applyOn(orientation);
        position = instruction.applyOn(position, orientation, lawn);
    }

    public void applyAll(String InstructionSequence) {
        String[] instructions = InstructionSequence.replaceAll(" ", "").split("");
        for (String instructionStr : instructions) {
            Instruction instruction = Instruction.parse(instructionStr);
            apply(instruction);
        }
    }

    @Override
    public String toString() {
        return position.getX().getValue() + " " + position.getY().getValue() + " " + orientation.toString();
    }
}

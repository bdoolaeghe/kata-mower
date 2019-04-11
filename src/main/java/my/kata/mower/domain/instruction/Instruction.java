package my.kata.mower.domain.instruction;

import lombok.Getter;

public enum Instruction {

    LEFT("L", new LeftInstructionProcessor()),
    RIGHT("R", new RightInstructionProcessor()),
    FORWARD("F", new ForwardInstructionProcessor());

    @Getter
    InstructionProcessor processor;
    String id;

    Instruction(String id, InstructionProcessor processor) {
        this.id = id;
        this.processor = processor;
    }

    public static Instruction fromId(String id) {
        for(Instruction value : values()) {
            if (value.id.equals(id.toUpperCase().trim()))
                return value;
        }
        throw new IllegalArgumentException("Unsupported instruction \"" + id + "\"");
    }

}

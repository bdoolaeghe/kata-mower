package my.kata.mower.domain.scenario;

import my.kata.mower.domain.instruction.Instruction;
import my.kata.mower.domain.mower.Mower;

import java.util.List;

public record MowerInstructions(Mower mower, List<Instruction> instructions) {
}

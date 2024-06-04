package my.kata.mower.domain.scenario;

import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.mower.Mower;

import java.util.List;

public record MowingScenario(Lawn lawn, List<MowerInstructions> mowerInstructions) {
    public List<Mower> execute() {
        return mowerInstructions
                .stream()
                .map(m -> m.mower().execute(m.instructions(), lawn))
                .toList();
    }
}

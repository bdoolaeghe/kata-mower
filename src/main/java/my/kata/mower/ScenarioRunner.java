package my.kata.mower;

import lombok.Data;
import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.mower.Mower;
import my.kata.mower.domain.instruction.Instruction;
import my.kata.mower.infra.ScenarioParser;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static my.kata.mower.domain.coordinates.X.x;
import static my.kata.mower.domain.coordinates.Y.y;


@Data
public class ScenarioRunner {

    public static void main(String[] args) throws IOException {
        run("scenario.txt", System.out);
    }

    public static void run(String scenarioFile, PrintStream out) throws IOException {
        //  parse scenario
        String[] scenarioLines = ScenarioParser.parseScenario(scenarioFile);

        Lawn lawn = ScenarioParser.parseLawnDescription(scenarioLines[0]);

        // for each couple of scenarioLines describing mower initial position / mower instruction sequence
        for (int i = 1; i < scenarioLines.length; i = i + 2) {
            try {
                String initialPosition = scenarioLines[i];
                Mower mower = ScenarioParser.parseMowerInitialPosition(initialPosition);
                String instructionSequence = scenarioLines[i + 1];
                List<Instruction> instructions = ScenarioParser.parseInstructions(instructionSequence);

                mower.applyAll(instructions, lawn);
                out.println(mower.toString());
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException("Malformed input file", e);
            }
        }
    }

}

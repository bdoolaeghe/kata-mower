package my.kata.mower;

import lombok.Data;
import my.kata.mower.coordinates.Coordinates;
import my.kata.mower.instructions.Instruction;
import my.kata.mower.orientation.Orientation;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static my.kata.mower.coordinates.Coordinates.coordinates;
import static my.kata.mower.coordinates.X.x;
import static my.kata.mower.coordinates.Y.y;


@Data
public class ScenarioRunner {

    public static void main(String[] args) throws IOException {
        run("scenario.txt", System.out);
    }

    public static void run(String scenarioFile, PrintStream out) throws IOException {
        String scenarioStr = new String(Files.readAllBytes(Paths.get(scenarioFile)));
        String[] lines = scenarioStr.split("\n");

        //  parse scenario
        Lawn lawn = parseLawnDescription(lines[0]);

        // for each couple of lines describing mower initial position / mower instruction sequence
        for (int i = 1; i < lines.length; i = i + 2) {
            try {
                String initialPosition = lines[i];
                Mower mower = parseMowerInitialPosition(initialPosition);
                String instructionSequence = lines[i + 1];
                List<Instruction> instructions = parseInstructions(instructionSequence);

                mower.applyAll(instructions, lawn);
                out.println(mower.toString());
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException("Malformed input file", e);
            }
        }
    }

    private static List<Instruction> parseInstructions(String instructionSequence) {
        return Stream.of(instructionSequence.replaceAll(" ", "").split(""))
                .map(Instruction::parse).collect(toList());
    }

    private static Mower parseMowerInitialPosition(String initialPositionLine) {
        // create mower
        String[] initialPositionStr = initialPositionLine.split(" ");
        Coordinates mowerInitialPosition = coordinates(x(initialPositionStr[0]), y(initialPositionStr[1]));
        Orientation mowerInitialOrientation = Orientation.parse(initialPositionStr[2]);
        return new Mower(mowerInitialPosition, mowerInitialOrientation);
    }

    private static Lawn parseLawnDescription(String lawnDescriptionLine) {
        String[] lawnCornerStr = lawnDescriptionLine.split(" ");
        return new Lawn(coordinates(
                x(lawnCornerStr[0]),
                y(lawnCornerStr[1])));
    }

}

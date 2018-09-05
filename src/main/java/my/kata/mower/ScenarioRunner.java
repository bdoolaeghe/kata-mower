package my.kata.mower;

import lombok.Data;
import my.kata.mower.coordinates.Coordinates;
import my.kata.mower.orientation.Orientation;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static my.kata.mower.coordinates.Coordinates.coordinates;
import static my.kata.mower.coordinates.X.x;
import static my.kata.mower.coordinates.Y.y;


@Data
public class ScenarioRunner {

    public static void main(String[] args) throws IOException {
        run("scenario.txt", System.out);
    }

    public static void run(String scenarioFile, PrintStream out) throws IOException {
        ScenarioRunner scenario = new ScenarioRunner();
        String scenarioStr = new String(Files.readAllBytes(Paths.get(scenarioFile)));
        String[] lines = scenarioStr.split("\n");

        //  parse scenario
        Lawn lawn = parseLawnDescription(lines[0]);

        for (int i = 1; i < lines.length; i = i + 2) {
            try {
                String initialPosition = lines[i];
                Mower mower = parseMowerInitialPosition(initialPosition, lawn);
                String instructionSequence = lines[i + 1];
                mower.applyAll(instructionSequence);
                out.println(mower.toString());
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException("Malformed input file", e);
            }
        }
    }

    private static Mower parseMowerInitialPosition(String line, Lawn lawn) {
        // create mower
        String[] initialPositionStr = line.split(" ");
        Coordinates mowerInitialPosition = coordinates(x(initialPositionStr[0]), y(initialPositionStr[1]));
        Orientation mowerInitialOrientation = Orientation.parse(initialPositionStr[2]);
        return new Mower(lawn, mowerInitialPosition, mowerInitialOrientation);
    }

    private static Lawn parseLawnDescription(String line) {
        String[] lawnCornerStr = line.split(" ");
        return new Lawn(coordinates(
                x(lawnCornerStr[0]),
                y(lawnCornerStr[1])));
    }

}

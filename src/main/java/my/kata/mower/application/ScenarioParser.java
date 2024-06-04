package my.kata.mower.application;

import my.kata.mower.domain.instruction.Instruction;
import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.mower.Mower;
import my.kata.mower.domain.geography.coordinates.Coordinates;
import my.kata.mower.domain.geography.orientation.Orientation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static my.kata.mower.domain.geography.coordinates.Coordinates.coordinates;
import static my.kata.mower.domain.geography.coordinates.X.x;
import static my.kata.mower.domain.geography.coordinates.Y.y;

public class ScenarioParser {

    public static String[] parseScenario(String scenarioFile) throws IOException {
        String scenarioStr = new String(Files.readAllBytes(Paths.get(scenarioFile)));
        return scenarioStr.split("\n");
    }

    public static Lawn parseLawnDescription(String lawnDescriptionLine) {
        String[] lawnCornerStr = lawnDescriptionLine.split(" ");
        return new Lawn(coordinates(
                x(lawnCornerStr[0]),
                y(lawnCornerStr[1])));
    }

    public static Mower parseMowerInitialPosition(String initialPositionLine) {
        // create mower
        String[] initialPositionStr = initialPositionLine.split(" ");
        Coordinates mowerInitialPosition = coordinates(x(initialPositionStr[0]), y(initialPositionStr[1]));
        Orientation mowerInitialOrientation = Orientation.fromLetter(initialPositionStr[2]);
        return new Mower(mowerInitialPosition, mowerInitialOrientation);
    }

    public static List<Instruction> parseInstructions(String instructionSequence) {
        return Stream.of(instructionSequence.replaceAll(" ", "").split(""))
                .map(Instruction::fromCode)
                .collect(toList());
    }

}

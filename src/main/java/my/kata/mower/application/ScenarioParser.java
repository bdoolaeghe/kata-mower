package my.kata.mower.application;

import my.kata.mower.domain.geography.orientation.Orientation;
import my.kata.mower.domain.instruction.Instruction;
import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.mower.Mower;
import my.kata.mower.domain.scenario.MowerInstructions;
import my.kata.mower.domain.scenario.MowingScenario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static my.kata.mower.domain.geography.coordinates.Coordinates.coordinates;
import static my.kata.mower.domain.geography.coordinates.X.x;
import static my.kata.mower.domain.geography.coordinates.Y.y;

class ScenarioParser {

    static MowingScenario parseScenario(String scenarioFile) throws IOException {
        var scenarioLines = parseSAsStringLines(scenarioFile);
        var lawn = parseLawnDescription(scenarioLines[0]);
        var mowerInstructions = parseMowerInstructions(scenarioLines);
        return new MowingScenario(lawn, mowerInstructions);
    }

    private static List<MowerInstructions> parseMowerInstructions(String[] scenarioLines) {
        var mowerInstructions = new ArrayList<MowerInstructions>();

        // for each couple of scenarioLines describing mower initial position / mower instruction sequence
        for (var i = 1; i < scenarioLines.length; i = i + 2) {
            try {
                var initialPosition = scenarioLines[i];
                var mower = ScenarioParser.parseMowerInitialPosition(initialPosition);
                var instructionSequence = scenarioLines[i + 1];
                var instructions = ScenarioParser.parseInstructions(instructionSequence);
                mowerInstructions.add(new MowerInstructions(mower, instructions));
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException("Malformed input file", e);
            }
        }
        return mowerInstructions;
    }

    private static String[] parseSAsStringLines(String scenarioFile) throws IOException {
        var scenarioStr = new String(Files.readAllBytes(Paths.get(scenarioFile)));
        return scenarioStr.split("\n");
    }

    private static Lawn parseLawnDescription(String lawnDescriptionLine) {
        var lawnCornerStr = lawnDescriptionLine.split(" ");
        return new Lawn(coordinates(
                x(lawnCornerStr[0]),
                y(lawnCornerStr[1])));
    }

    private static Mower parseMowerInitialPosition(String initialPositionLine) {
        // create mower
        var initialPositionStr = initialPositionLine.split(" ");
        var mowerInitialPosition = coordinates(x(initialPositionStr[0]), y(initialPositionStr[1]));
        var mowerInitialOrientation = Orientation.fromLetter(initialPositionStr[2]);
        return new Mower(mowerInitialPosition, mowerInitialOrientation);
    }

    private static List<Instruction> parseInstructions(String instructionSequence) {
        return Stream.of(instructionSequence.replaceAll(" ", "").split(""))
                .map(Instruction::fromCode)
                .collect(toList());
    }

    public static String asString(List<Mower> mowers) {
        return  mowers.stream()
                .map(ScenarioParser::formatMower)
                .collect(joining());
    }

    private static String formatMower(Mower m) {
        return MessageFormat.format(
                "{0} {1} {2}\n",
                m.getPosition().x(),
                m.getPosition().y(),
                m.getOrientation().code
        );
    }
}

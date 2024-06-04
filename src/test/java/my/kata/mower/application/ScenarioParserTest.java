package my.kata.mower.application;

import my.kata.mower.domain.instruction.Instruction;
import my.kata.mower.domain.lawn.Lawn;
import my.kata.mower.domain.mower.Mower;
import my.kata.mower.domain.scenario.MowerInstructions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static my.kata.mower.application.ScenarioParser.parseScenario;
import static my.kata.mower.domain.geography.coordinates.Coordinates.coordinates;
import static my.kata.mower.domain.geography.coordinates.X.x;
import static my.kata.mower.domain.geography.coordinates.Y.y;
import static my.kata.mower.domain.geography.orientation.Orientation.EAST;
import static my.kata.mower.domain.geography.orientation.Orientation.NORTH;
import static org.assertj.core.api.Assertions.assertThat;

class ScenarioParserTest {

    @Test
    void should_parse_scnario() throws IOException {
        var scenario = parseScenario("./scenario.txt");

        assertThat(scenario.lawn()).isEqualTo(new Lawn(coordinates(x(5), y(5))));
        assertThat(scenario.mowerInstructions()).extracting(MowerInstructions::mower)
                .containsExactly(
                        new Mower(coordinates(x(1), y(2)), NORTH),
                        new Mower(coordinates(x(3), y(3)), EAST)
                );
        assertThat(scenario.mowerInstructions()).extracting(MowerInstructions::instructions)
                .containsExactly(
                        List.of(
                                Instruction.fromCode("L"),
                                Instruction.fromCode("F"),
                                Instruction.fromCode("L"),
                                Instruction.fromCode("F"),
                                Instruction.fromCode("L"),
                                Instruction.fromCode("F"),
                                Instruction.fromCode("L"),
                                Instruction.fromCode("F"),
                                Instruction.fromCode("F")
                        ),
                        List.of(
                                Instruction.fromCode("F"),
                                Instruction.fromCode("F"),
                                Instruction.fromCode("R"),
                                Instruction.fromCode("F"),
                                Instruction.fromCode("F"),
                                Instruction.fromCode("R"),
                                Instruction.fromCode("F"),
                                Instruction.fromCode("R"),
                                Instruction.fromCode("R"),
                                Instruction.fromCode("F")
                        )
                );
    }

    @Test
    void should_display_as_string_the_final_mowers_position() {
        var result = ScenarioParser.asString(List.of(
                new Mower(coordinates(x(1), y(2)), NORTH),
                new Mower(coordinates(x(3), y(3)), EAST)
        ));

        assertThat(result).isEqualTo(
                """
                        1 2 N
                        3 3 E
                        """);
    }
}
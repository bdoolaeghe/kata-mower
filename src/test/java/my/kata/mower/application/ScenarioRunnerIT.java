package my.kata.mower.application;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ScenarioRunnerIT {

    @Test
    public void should_complete_basic_2_mowers_scenario() throws IOException {
        var outputStream = new ByteArrayOutputStream();
        ScenarioRunner.run("scenario.txt", new PrintStream(outputStream));

        assertThat(outputStream.toString()).isEqualTo(
                """
                        1 3 N
                        5 1 E
                        
                        """
        );
    }
}

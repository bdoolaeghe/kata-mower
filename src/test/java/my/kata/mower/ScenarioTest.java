package my.kata.mower;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ScenarioTest {

    @Test
    public void should_complete_basic_2_mowers_scenario() throws IOException {
        var outputStream = new ByteArrayOutputStream();

        ScenarioRunner.run("scenario.txt", new PrintStream(outputStream));
        String[] outputLines = outputStream.toString().split("\\n");

        assertThat(outputLines.length).isEqualTo(2);
        assertThat(outputLines[0]).isEqualTo("(1,3) N");
        assertThat(outputLines[1]).isEqualTo("(5,1) E");
    }
}

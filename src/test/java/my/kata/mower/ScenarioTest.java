package my.kata.mower;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ScenarioTest {

    @Test
    public void should_complete_basic_2_mowers_scenario() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ScenarioRunner.run("scenario.txt", new PrintStream(outputStream));
        String[] outputLines = outputStream.toString().split("\\n");

        assertThat(outputLines.length, is(2));
        assertThat(outputLines[0], is("1 3 N"));
        assertThat(outputLines[1], is("5 1 E"));
    }
}

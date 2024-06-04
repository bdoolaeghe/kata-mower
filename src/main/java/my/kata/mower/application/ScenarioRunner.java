package my.kata.mower.application;

import java.io.IOException;
import java.io.PrintStream;


public class ScenarioRunner {

    public static void main(String[] args) throws IOException {
        run("scenario.txt", System.out);
    }

    public static void run(String scenarioFile, PrintStream out) throws IOException {
        var scenario = ScenarioParser.parseScenario(scenarioFile);
        var finalMowers = scenario.execute();
        out.println(ScenarioParser.asString(finalMowers));
    }

}

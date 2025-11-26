package hexlet.code;

import picocli.CommandLine;

import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException {
        CommandLine cmd = new CommandLine(new Differ());
        int exitCode = cmd.execute(args);
        System.exit(exitCode);
    }
}

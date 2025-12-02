package hexlet.code;

import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

import hexlet.code.Differ;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.Set;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<String> {

        @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
        private String filepath1;

        @CommandLine.Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
        private String filepath2;

        @CommandLine.Option(names = {"-f", "--format"}, defaultValue = "stylish", paramLabel = "format", description = "output format [default: stylish]")
        private String format;

        @Override
        public String call() throws Exception {
            return Differ.generate(filepath1, filepath2);
        }

    public static void main(String[] args) throws IOException {
        CommandLine cmd = new CommandLine(new App());
        int exitCode = cmd.execute(args);
        String result = cmd.getExecutionResult();
        System.out.println(result);
        System.exit(exitCode);
    }
}

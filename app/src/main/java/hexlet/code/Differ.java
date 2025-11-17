package hexlet.code;

import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class Differ implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}

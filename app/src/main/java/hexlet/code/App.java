package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import hexlet.code.Differ;
import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;


public class App {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Differ()).execute(args);
        System.exit(exitCode);
    }
}

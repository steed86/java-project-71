import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.nio.file.Files;

import hexlet.code.Differ;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDiffer {
    @Test
    public void testJsonComparison() throws Exception {
        var file1PathString = "src/test/resources/file1.json";
        var file2PathString = "src/test/resources/file2.json";
        var resultFilePathString = "src/test/resources/result1.txt";

        var pathToResultFile = Paths.get(resultFilePathString);

        var expected = Files.readString(pathToResultFile).trim();

        var actual = Differ.generate(file1PathString, file2PathString);

        assertEquals(expected, actual);
    }
}

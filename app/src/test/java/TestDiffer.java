import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.nio.file.Files;

import hexlet.code.Differ;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDiffer {
    @Test
    public void testJsonComparison() throws Exception {
        var file1PathString = "src/test/resources/testJsonComparison/file1.json";
        var file2PathString = "src/test/resources/testJsonComparison/file2.json";
        var resultFilePathString = "src/test/resources/testJsonComparison/result1.txt";

        var pathToResultFile = Paths.get(resultFilePathString);

        var expected = Files.readString(pathToResultFile).trim();

        var actual = Differ.generate(file1PathString, file2PathString);

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonComparison2() throws Exception {
        var file1PathString = "src/test/resources/testJsonComparison2/file1.json";
        var file2PathString = "src/test/resources/testJsonComparison2/file2.json";
        var resultFilePathString = "src/test/resources/testJsonComparison2/result1.txt";

        var pathToResultFile = Paths.get(resultFilePathString);

        var expected = Files.readString(pathToResultFile).trim();

        var actual = Differ.generate(file1PathString, file2PathString);

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonComparison3() throws Exception {
        var file1PathString = "src/test/resources/testJsonComparison3/file1.json";
        var file2PathString = "src/test/resources/testJsonComparison3/file2.json";
        var resultFilePathString = "src/test/resources/testJsonComparison3/result1.txt";

        var pathToResultFile = Paths.get(resultFilePathString);

        var expected = Files.readString(pathToResultFile).trim();

        var actual = Differ.generate(file1PathString, file2PathString);

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonComparison4() throws Exception {
        var file1PathString = "src/test/resources/testJsonComparison4/file1.json";
        var file2PathString = "src/test/resources/testJsonComparison4/file2.json";
        var resultFilePathString = "src/test/resources/testJsonComparison4/result1.txt";

        var pathToResultFile = Paths.get(resultFilePathString);

        var expected = Files.readString(pathToResultFile).trim();

        var actual = Differ.generate(file1PathString, file2PathString);

        assertEquals(expected, actual);
    }
}

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import hexlet.code.Differ;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDiffer {

    public static String file1PathString = "file1";
    public static String file2PathString = "file2";
    public static String resultFilePathString = "result1";
    public static String resultFileFormat = "txt";

    public static Path getFixturePath(String testName, String filename, String fileFormat) {
        return Paths.get("src", "test", "resources", "fixtures", testName, filename + "." + fileFormat)
                    .toAbsolutePath()
                    .normalize();
    }

    public static String getFixturePathStr(String testName, String filename, String fileFormat) {
        return getFixturePath(testName, filename, fileFormat).toString();
    }

    public static String getFileContent(String testName, String filePathString, String fileFormat) throws Exception {
        var pathToFile = getFixturePath(testName, filePathString, fileFormat);
        return Files.readString(pathToFile).trim();
    }

    public static String getActualResult(String testName, String fileFormat) throws Exception {
        return Differ.generate(
                getFixturePathStr(testName, file1PathString, fileFormat),
                getFixturePathStr(testName, file2PathString, fileFormat));
    }

    @Test
    public void testJsonComparison() throws Exception {
        var testName = "testJsonComparison";
        var comparisonFilesFormat = "json";

        var expected = getFileContent(testName, resultFilePathString, resultFileFormat);

        var actual = getActualResult(testName, comparisonFilesFormat);

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonComparison2() throws Exception {
        var testName = "testJsonComparison2";
        var comparisonFilesFormat = "json";

        var expected = getFileContent(testName, resultFilePathString, resultFileFormat);

        var actual = getActualResult(testName, comparisonFilesFormat);

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonComparison3() throws Exception {
        var testName = "testJsonComparison3";
        var comparisonFilesFormat = "json";

        var expected = getFileContent(testName, resultFilePathString, resultFileFormat);

        var actual = getActualResult(testName, comparisonFilesFormat);

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonComparison4() throws Exception {
        var testName = "testJsonComparison4";
        var comparisonFilesFormat = "json";

        var expected = getFileContent(testName, resultFilePathString, resultFileFormat);

        var actual = getActualResult(testName, comparisonFilesFormat);

        assertEquals(expected, actual);
    }

    @Test
    public void testYamlComparison1() throws Exception {
        var testName = "testYamlComparison1";
        var comparisonFilesFormat = "yml";

        var expected = getFileContent(testName, resultFilePathString, resultFileFormat);

        var actual = getActualResult(testName, comparisonFilesFormat);

        assertEquals(expected, actual);
    }

    @Test
    public void testYamlComparison2() throws Exception {
        var testName = "testYamlComparison2";
        var comparisonFilesFormat = "yml";

        var expected = getFileContent(testName, resultFilePathString, resultFileFormat);

        var actual = getActualResult(testName, comparisonFilesFormat);

        assertEquals(expected, actual);
    }

    @Test
    public void testYamlComparison3() throws Exception {
        var testName = "testYamlComparison3";
        var comparisonFilesFormat = "yml";

        var expected = getFileContent(testName, resultFilePathString, resultFileFormat);

        var actual = getActualResult(testName, comparisonFilesFormat);

        assertEquals(expected, actual);
    }

    @Test
    public void testYamlComparison4() throws Exception {
        var testName = "testYamlComparison4";
        var comparisonFilesFormat = "yml";

        var expected = getFileContent(testName, resultFilePathString, resultFileFormat);

        var actual = getActualResult(testName, comparisonFilesFormat);

        assertEquals(expected, actual);
    }
}

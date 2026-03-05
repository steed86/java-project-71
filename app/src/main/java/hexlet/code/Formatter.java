package hexlet.code;

import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Json;

public class Formatter {

    public static String formatDifferResult(HashMap<String, HashMap<String, Object>> differResult,
                                            String formatName) throws Exception {

        String result = "";

        ObjectMapper mapper = new ObjectMapper();

        if (formatName.equals("stylish")) {
            result = Stylish.formatDifferResult(differResult);

        } else if (formatName.equals("plain")) {
            result = Plain.formatDifferResult(differResult);
        } else if (formatName.equals("json")) {
            result = Json.formatDifferResult(differResult);
        }

        return result;
    }
}

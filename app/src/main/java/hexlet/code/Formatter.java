package hexlet.code;

import java.util.HashMap;

import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;

public class Formatter {

    public static String formatDifferResult(HashMap<String, HashMap<String, Object>> differResult, String formatName) {

        String result = "";

        if (formatName.equals("stylish")) {
            result = Stylish.formatDifferResult(differResult);

        } else if (formatName.equals("plain")) {
            result = Plain.formatDifferResult(differResult);
        }

        return result;
    }
}

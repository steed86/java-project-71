package hexlet.code;

import java.util.HashMap;

public class Formatter {
    public static String resultStringBuilder(String key, String value, String resultSign) {
        var delimiter = ": ";
        var firstPart = "  " + (resultSign.equals("+") || resultSign.equals("-") ? resultSign : " ") + " ";
        var lastPart = "\n";
        return firstPart + key + delimiter + value + lastPart;
    }

    public static String formatDifferResult(HashMap<String, HashMap<String, String>> differResult, String format) {

        String result = "";

        if (format.equals("stylish")) {
            result = "{\n";

            var keys = differResult.keySet();



            for (var key : keys) {
                var currentResult = differResult.get(key);
                if (currentResult.get("result").equals("same")) {
                    result = result + resultStringBuilder(key, currentResult.get("old"), "=");
                } else if (currentResult.get("result").equals("changed")) {
                    result = result + resultStringBuilder(key, currentResult.get("old"), "-");
                    result = result + resultStringBuilder(key, currentResult.get("new"), "+");
                } else if (currentResult.get("result").equals("deleted")) {
                    result = result + resultStringBuilder(key, currentResult.get("old"), "-");
                } else if (currentResult.get("result").equals("added")) {
                    result = result + resultStringBuilder(key, currentResult.get("new"), "+");
                }
            }

            result = result + "}";

        }
        return result;
    }
}

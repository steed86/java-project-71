package hexlet.code.formatters;

import java.util.HashMap;

public class Stylish {

    public static String addNewResultString(String currentResult, String key, Object oldValue, Object newValue,
                                            String resultCode) {
        var newResult = "";

        var oldValueStr = String.valueOf(oldValue);
        var newValueStr = String.valueOf(newValue);

        if (resultCode.equals("same")) {
            newResult = newResult.concat("    " + key + ": " + oldValueStr + "\n");
        } else if (resultCode.equals("changed")) {
            newResult = newResult.concat("  - " + key + ": " + oldValueStr + "\n");
            newResult = newResult.concat("  + " + key + ": " + newValueStr + "\n");
        } else if (resultCode.equals("deleted")) {
            newResult = newResult.concat("  - " + key + ": " + oldValueStr + "\n");
        } else if (resultCode.equals("added")) {
            newResult = newResult.concat("  + " + key + ": " + newValueStr + "\n");
        }

        return currentResult + newResult;
    }

    public static String formatDifferResult(HashMap<String, HashMap<String, Object>> differResult) {

        var result = "{\n";

        var keys = differResult.keySet();

        for (var key : keys) {
            var currentResultMap = differResult.get(key);
            var currentResultCode = String.valueOf(currentResultMap.get("result"));
            result = addNewResultString(result, key, currentResultMap.get("old"),
                    currentResultMap.get("new"), currentResultCode);
        }

        result = result + "}";

        return result;
    }
}

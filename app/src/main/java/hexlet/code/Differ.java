package hexlet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Differ {
    public static ArrayList<String> getKeysList(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Set<String> firstMapKeys = firstMap.keySet();
        Set<String> secondMapKeys = secondMap.keySet();

        ArrayList<String> allKeys = new ArrayList<>();

        for (var key : firstMapKeys) {
            if (!allKeys.contains(key)) {
                allKeys.add(key);
            }
        }

        for (var key : secondMapKeys) {
            if (!allKeys.contains(key)) {
                allKeys.add(key);
            }
        }

        Collections.sort(allKeys);

        return allKeys;
    }

    public static String resultStringBuilder(String key, String value, String resultSign) {
        var delimiter = ": ";
        var firstPart = "  " + (resultSign.equals("+") || resultSign.equals("-") ? resultSign : " ") + " ";
        var lastPart = "\n";
        return firstPart + key + delimiter + value + lastPart;
    }

    public static String generate(String filepath1, String filepath2) throws Exception {

        var firstFileMap = Parser.getMapFromFile(filepath1);
        var secondFileMap = Parser.getMapFromFile(filepath2);

        var allKeys = getKeysList(firstFileMap, secondFileMap);

        String result = "{\n";

        for (var key : allKeys) {
            if (firstFileMap.containsKey(key)) {
                if (secondFileMap.containsKey(key)) {
                    var firstElement = firstFileMap.get(key).toString();
                    var secondElement = secondFileMap.get(key).toString();

                    if (firstElement.equals(secondElement)) {
                        result = result + resultStringBuilder(key, firstElement, "=");
                    } else {
                        result = result + resultStringBuilder(key, firstElement, "-");
                        result = result + resultStringBuilder(key, secondElement, "+");
                    }
                } else {
                    var firstElement = firstFileMap.get(key).toString();
                    result = result + resultStringBuilder(key, firstElement, "-");
                }
            } else {
                if (secondFileMap.containsKey(key)) {
                    var secondElement = secondFileMap.get(key).toString();
                    result = result + resultStringBuilder(key, secondElement, "+");
                }
            }
        }
        result = result + "}";
        return result;
    }
}

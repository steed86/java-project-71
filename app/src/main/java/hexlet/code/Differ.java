package hexlet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
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

    public static HashMap<String, HashMap<String, Object>> generate(
            String filepath1, String filepath2) throws Exception {
        var firstFileMap = Parser.getMapFromFile(filepath1);
        var secondFileMap = Parser.getMapFromFile(filepath2);

        var allKeys = getKeysList(firstFileMap, secondFileMap);

        var comparisonResult = new LinkedHashMap<String, HashMap<String, Object>>();

        for (var key : allKeys) {
            comparisonResult.put(key, new HashMap<String, Object>());
            if (firstFileMap.containsKey(key)) {
                if (secondFileMap.containsKey(key)) {
                    var firstElement = Objects.requireNonNullElse(firstFileMap.get(key), "null");
                    var secondElement = Objects.requireNonNullElse(secondFileMap.get(key), "null");

                    if (firstElement.equals(secondElement)) {
                        comparisonResult.get(key).put("old", firstElement);
                        comparisonResult.get(key).put("new", secondElement);
                        comparisonResult.get(key).put("result", "same");
                    } else {
                        comparisonResult.get(key).put("old", firstElement);
                        comparisonResult.get(key).put("new", secondElement);
                        comparisonResult.get(key).put("result", "changed");
                    }
                } else {
                    var firstElement = firstFileMap.get(key);
                    comparisonResult.get(key).put("old", firstElement);
                    comparisonResult.get(key).put("result", "deleted");
                }
            } else {
                if (secondFileMap.containsKey(key)) {
                    var secondElement = secondFileMap.get(key);
                    comparisonResult.get(key).put("new", secondElement);
                    comparisonResult.get(key).put("result", "added");
                }
            }

        }

        return comparisonResult;
    }
}

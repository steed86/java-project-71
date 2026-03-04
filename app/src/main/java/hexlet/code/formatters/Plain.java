package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plain {

    public static boolean isJson(Object json) {

        if (String.valueOf(json).equals("null") || String.valueOf(json).equals("true")
                || String.valueOf(json).equals("false")) {
            return false;
        }

        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result = mapper.writeValueAsString(json);
        } catch (JSONException | JsonProcessingException e) {
            return false;
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            var resultDesir = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() { });
        } catch (JsonProcessingException e) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                var resultDesir2 = objectMapper.readValue(result, new TypeReference<List<String>>() { });
            } catch (JsonProcessingException e2) {
                return false;
            }
        }

        return true;
    }

    public static String addNewResultString(String currentResult, String key, Object oldValue, Object newValue,
                                            String resultCode) {
        var newResult = "";

        var oldValueStr = String.valueOf(oldValue);
        var newValueStr = String.valueOf(newValue);

        if (!StringUtils.isNumeric(oldValueStr)) {
            if (isJson(oldValue)) {
                oldValueStr = "[complex value]";
            } else if (!(oldValueStr.equals("null") || oldValueStr.equals("true") || oldValueStr.equals("false"))) {
                oldValueStr = "'" + oldValueStr + "'";
            }
        }

        if (!StringUtils.isNumeric(newValueStr)) {
            if (isJson(newValue)) {
                newValueStr = "[complex value]";
            } else if (!(newValueStr.equals("null") || newValueStr.equals("true") || newValueStr.equals("false"))) {
                newValueStr = "'" + newValueStr + "'";
            }
        }

        if (resultCode.equals("changed")) {
            newResult = newResult.concat("Property '" + key + "' was updated. From " + oldValueStr + " to "
                    + newValueStr);
        } else if (resultCode.equals("deleted")) {
            newResult = newResult.concat("Property '" + key + "' was removed");
        } else if (resultCode.equals("added")) {
            newResult = newResult.concat("Property '" + key + "' was added with value: " + newValueStr);
        }

        var finalResult = "";

        if (newResult.isEmpty()) {
            finalResult = currentResult;
        } else if (currentResult.isEmpty()) {
            finalResult = newResult;
        } else {
            finalResult = currentResult + "\n" + newResult;
        }

        return finalResult;
    }

    public static String formatDifferResult(HashMap<String, HashMap<String, Object>> differResult) {

        var result = "";

        var keys = differResult.keySet();

        for (var key : keys) {
            var currentResultMap = differResult.get(key);
            var currentResultCode = String.valueOf(currentResultMap.get("result"));
            result = addNewResultString(result, key, currentResultMap.get("old"), currentResultMap.get("new"),
                    currentResultCode);
        }

        return result;
    }
}

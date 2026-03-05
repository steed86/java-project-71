package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class Json {

    public static String formatDifferResult(HashMap<String, HashMap<String, Object>> differResult) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(differResult);
    }

}

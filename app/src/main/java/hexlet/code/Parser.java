package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;

public class Parser {
    public static Map<String, Object> getMapFromFile(String filepath) throws Exception {
        //получаем путь к файлу
        Path filepathObj = Paths.get(filepath).toAbsolutePath().normalize();

        //проверяем существование  файла
        if (!Files.exists(filepathObj)) {
            throw new Exception("File '" + filepath + "' does not exist");
        }

        //читаем файл
        String fileTxt = Files.readString(filepathObj).trim();

        Map<String, Object> result = Collections.emptyMap();

        String fileFormat = filepath.substring(filepath.lastIndexOf(".") + 1);

        if (fileFormat.equals("json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            result = objectMapper.readValue(fileTxt, new TypeReference<Map<String, Object>>() {
            });
        } else if (fileFormat.equals("yml")) {
            if (!(fileTxt.isEmpty())) {
                //если файл не пустой, то десериализуем его
                ObjectMapper objectMapper = new YAMLMapper();
                return objectMapper.readValue(fileTxt, new TypeReference<Map<String, Object>>() {
                });
            }
        }

        return result;
    }
}

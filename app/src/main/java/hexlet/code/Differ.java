package hexlet.code;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.Set;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {
 public static String generate(String filepath1, String filepath2) throws Exception {
        /* Для отладки
        System.out.println("Hello from inside of Differ class!");
        System.out.println("path to the first file is :=: " + filepath1);
        System.out.println("path to the second file is :=: " + filepath2);
        */

        //получаем пути к файлам
        Path filepath1Obj = Paths.get(filepath1).toAbsolutePath().normalize();
        Path filepath2Obj = Paths.get(filepath2).toAbsolutePath().normalize();

        /* Для отладки
        System.out.println("Normalized path to the first file is :=: " + filepath1Obj);
        System.out.println("Normalized path to the second file is :=: " + filepath2Obj);
         */

        //проверяем существование  файлов
        if (!Files.exists(filepath1Obj)) {
            throw new Exception("First file '" + filepath1 + "' does not exist");
        }

        if (!Files.exists(filepath2Obj)) {
            throw new Exception("Second file '" + filepath2 + "' does not exist");
        }

        //читаем файлы
        String firstFileTxt = Files.readString(filepath1Obj);
        String secondFileTxt = Files.readString(filepath2Obj);

        /* Для отладки - вывод содержимого файлов в stdout
        System.out.println("first file content is:");
        System.out.println(firstFileTxt);
        System.out.println("second file content is:");
        System.out.println(secondFileTxt);
        */

        //десериализуем файлы
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> firstFileMap = objectMapper.readValue(firstFileTxt, new TypeReference<Map<String,Object>>(){});
        Map<String, Object> secondFileMap = objectMapper.readValue(secondFileTxt, new TypeReference<Map<String,Object>>(){});

        Set<String> firstFileKeys = firstFileMap.keySet();
        Set<String> secondFileKeys = secondFileMap.keySet();

        ArrayList<String> allKeys = new ArrayList<>();

        for (var key : firstFileKeys) {
            if (!allKeys.contains(key)) {
                allKeys.add(key);
            }
        }

        for (var key : secondFileKeys) {
            if (!allKeys.contains(key)) {
                allKeys.add(key);
            }
        }

        Collections.sort(allKeys);

        String result = "{\n";

        for (var key : allKeys) {
            if (firstFileMap.containsKey(key)) {
                if (secondFileMap.containsKey(key)) {
                    var firstElement = firstFileMap.get(key);
                    var secondElement = secondFileMap.get(key);

                    if (firstElement.equals(secondElement)) {
                        result = result + "    " + key + ": " + firstElement + "\n";
                    } else {
                        result = result + "  - " + key + ": " + firstElement + "\n";
                        result = result + "  + " + key + ": " + secondElement + "\n";
                    }
                } else {
                    var firstElement = firstFileMap.get(key);
                    result = result + "  - " + key + ": " + firstElement + "\n";
                }
            } else {
                if (secondFileMap.containsKey(key)) {
                    var secondElement = secondFileMap.get(key);
                    result = result + "  + " + key + ": " + secondElement + "\n";
                }
            }
        }
        result = result + "}";
        return result;
    }
}

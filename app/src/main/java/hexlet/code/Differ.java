package hexlet.code;

import java.util.Map;
import java.util.concurrent.Callable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class Differ implements Callable<Integer> {
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", paramLabel = "format", description = "output format [default: stylish]")
    private String format;

    @Override
    public Integer call() throws Exception {
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

        //десериализуем файлы и выводим в stdout
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> firstFileMap = objectMapper.readValue(firstFileTxt, new TypeReference<Map<String,Object>>(){});
        System.out.println(firstFileMap);
        Map<String, Object> secondFileMap = objectMapper.readValue(secondFileTxt, new TypeReference<Map<String,Object>>(){});
        System.out.println(secondFileMap);
        return 23;
    }
}

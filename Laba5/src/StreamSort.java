import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class StreamSort {
    public static Map<Integer, List<String>> processPeopleFile(String filename) throws IOException {
        Valid valid = new Valid();

        return Files.lines(Paths.get(filename))
                .map(line -> line.split(":"))                                                           // Разделяем имя и номер
                .filter(parts -> parts.length == 2 && !parts[1].trim().isEmpty())                           // Убираем людей без номеров
                .map(parts -> new String[]{formatName(parts[0].trim()), parts[1].trim()})                   // Форматируем имя
                .filter(parts -> valid.isInteger(parts[1]))
                .collect(Collectors.groupingBy(
                        parts -> Integer.parseInt(parts[1]),                                                // Группируем по номеру
                        Collectors.mapping(
                                parts -> parts[0],
                                Collectors.toList()
                        )
                ));
    }

    private static String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
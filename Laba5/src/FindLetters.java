import java.io.*;
import java.util.*;

public class FindLetters {
    //Поиск согласных которые встречаются ровно 1 раз
    public Set<Character> findConsonants(String filename) throws IOException {
        Valid valid = new Valid();
        String text = readFile(filename);
        String[] words = text.split("[^а-яёА-ЯЁ]+");

        Map<Character, Integer> consonantCount = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            Set<Character> wordConsonants = new HashSet<>();
            for (char c : word.toCharArray()) {
                if (valid.isRussianConsonant(c)) {
                    wordConsonants.add(Character.toLowerCase(c));
                }
            }

            for (char consonant : wordConsonants) {
                consonantCount.put(consonant, consonantCount.getOrDefault(consonant, 0) + 1);
            }
        }

        Set<Character> result = new TreeSet<>();                                                        //Автоматически сортирует
        for (Map.Entry<Character, Integer> entry : consonantCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    //Чтение файла
    private String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        return content.toString();
    }
}
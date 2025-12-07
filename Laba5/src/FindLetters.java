import java.io.*;
import java.util.*;

public class FindLetters {
    //Поиск согласных которые встречаются ровно 1 раз
    public Set<Character> findConsonants(String filename) throws IOException {
        Valid valid = new Valid();
        String text = readFile(filename);
        String[] words = text.split("[^а-яёА-ЯЁ]+");

        Set<Character> allConsonants = new HashSet<>();
        Set<Character> duplicateConsonants = new HashSet<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            Set<Character> wordConsonants = new HashSet<>();
            for (char c : word.toCharArray()) {
                if (valid.isRussianConsonant(c)) {
                    char lowerC = Character.toLowerCase(c);
                    wordConsonants.add(lowerC);
                }
            }

            for (char consonant : wordConsonants) {
                if (allConsonants.contains(consonant)) {
                    duplicateConsonants.add(consonant);
                }
                allConsonants.add(consonant);
            }
        }

        Set<Character> result = new TreeSet<>();
        for (char consonant : allConsonants) {
            if (!duplicateConsonants.contains(consonant)) {
                result.add(consonant);
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

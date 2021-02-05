package week14.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Junior {

    private Map<String, Integer> result = new HashMap<>();

    public Map<String, Integer> countWords(BufferedReader reader, String... words) throws IOException {

        String line = "";
        while ((line = reader.readLine()) != null) {

            for (String word : words) {
                if (line.contains(word)) {
                    result.merge(word, 1, Integer::sum);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Junior junior = new Junior();
        Path path = Path.of("c:\\Training\\training-solutions\\hachiko1.srt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println(junior.countWords(reader, "Hachi", "haza", "pályaudvar", "jó", "Hachiko"));
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}

package week14.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Junior {

    private Map<String, Integer> result = new HashMap<>();

    public Map<String, Integer> countWords(Path path, String... words) {

        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("windows-1250"))) {
            lineProcessor(reader, words);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return result;
    }

    public void lineProcessor(BufferedReader reader, String[] words) throws IOException {
        String line = "";
        while ((line = reader.readLine()) != null) {
            lineFilter(words, line);
        }
    }

    private void lineFilter(String[] words, String line) {
        for (String word : words) {
            if (line.contains(word)) {
                int count = 1;
                count = inLineWordCounter(line, word); // Ha kell soron belül számolni
                result.merge(word, count, Integer::sum);
            }
        }
    }

    private int inLineWordCounter(String line, String find) {

        String[] parts = line.split("\\s");
        int counter = 0;
        for (String word : parts) {
            if (word.contains(find)) {
                counter++;
            }
        }
        return counter;
    }


    public static void main(String[] args) {
        Junior junior = new Junior();
        Path path = Path.of("hachiko.srt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("windows-1250"))) {
            System.out.println(junior.countWords(path, "Hachiko", "haza", "pályaudvar", "jó", "Hach"));
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}

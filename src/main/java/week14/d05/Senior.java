package week14.d05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Senior {

    public static final String CHARSET_NAME = "windows-1250";
    public static final String NAME_OF_THE_DOG = "Hach";

    public long countDog(Path path) {
        try (Stream<String> lines = Files.lines(path, Charset.forName(CHARSET_NAME))) {
            return lines
                    .filter(Senior::containsWord)
                    .flatMap(Senior::splitLine)
                    .filter(Senior::containsWord)
                    .count();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private static boolean containsWord(String line) {
        return line.contains(NAME_OF_THE_DOG);
    }

    private static Stream<? extends String> splitLine(String line) {
        return Stream.of(line.split(" "));
    }

    public static void main(String[] args) {
        Senior senior = new Senior();
        Path path = Path.of("hachiko.srt");

        System.out.println(senior.countDog(path));
    }


}

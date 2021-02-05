package week14.d05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Senior {

    public long countDog(Path path) {
        try (Stream<String> lines = Files.lines(path, Charset.forName("windows-1250"))) {
            return lines
                    .filter(line -> line.contains("Hach"))
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.contains("Hach"))
                    .peek(System.out::println)
                    .count();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public static void main(String[] args) {
        Senior senior = new Senior();
        Path path = Path.of("hachiko.srt");

        System.out.println(senior.countDog(path));
    }


}

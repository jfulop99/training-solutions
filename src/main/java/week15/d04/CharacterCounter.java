package week15.d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterCounter {


    public static final int SPACE = 32;

    public Map<CharType, Long> charCounter(Path path) {

        String wowels = "aáéiíuúüűöőó";
        String consoant = "qwrtzpsdfghjklyxcvbnm";


        try (Stream<String> stream = Files.lines(path)) {

            return stream
                    .map(String::toLowerCase)
                    .flatMapToInt(String::chars)
                    .filter(bySpace())
                    .mapToObj(CharType::getType)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private IntPredicate bySpace() {
        return c -> c != SPACE;
    }

    public static void main(String[] args) {
        CharacterCounter characterCounter = new CharacterCounter();
        System.out.println(characterCounter.charCounter(Path.of("input.txt")));


    }
}

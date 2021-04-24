package gyaxi.algorithms;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class WordsLength {
    public Map<Integer, Integer> getStatistic(String... content) {
        if (content == null) {
            throw new IllegalArgumentException("The parameter is a must!");
        }

        return Arrays.stream(content)
                .filter(Objects::nonNull)
                .flatMap(c -> Arrays.stream(c.split("[\\s,.!\"?]+")))
                .filter(s -> !s.isBlank())
                .collect(Collectors.toMap(String::length, v -> 1, Integer::sum));

    }
}

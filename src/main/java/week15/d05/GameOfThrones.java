package week15.d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfThrones {

    public Optional<Map.Entry<String, Long>> maxBattlePerHouse(Path path) {
        Map<String, Long> houses = new HashMap<>();

        try (Stream<String> lines = Files.lines(path)) {
            houses = lines
                    .skip(1)
                    .flatMap(s -> {
                        String[] parts = s.split(",");
                        return Stream.of(parts[5], parts[9]);
                    })
                    .filter(a -> !a.isBlank())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }


        return houses
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
    }

    public static void main(String[] args) {
        GameOfThrones gameOfThrones = new GameOfThrones();

        System.out.println(gameOfThrones.maxBattlePerHouse(Path.of("battles.csv")));
    }

}

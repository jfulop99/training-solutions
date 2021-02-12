package week15.d05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfThrones {

    private static Stream<String> getHousesFromLine(String s) {
        String[] parts = s.split(",");
        return Stream.of(parts).skip(5).limit(8);
    }

    public Optional<Map.Entry<String, Long>> maxBattlePerHouse(Path path) {
        Map<String, Long> houses = new HashMap<>();

        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            houses = lines
                    .skip(1)
                    .flatMap(GameOfThrones::getHousesFromLine)
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

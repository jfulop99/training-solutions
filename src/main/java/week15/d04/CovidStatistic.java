package week15.d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CovidStatistic {

    public static final int POS_OF_YEAR_WEEK = 1;
    public static final int POS_OF_CASES = 2;
    public static final String SELECTED_COUNTRY = "Hungary";

    public List<CovidStat> covidStat(Path path) {

        try (Stream<String> stream = Files.lines(path)) {

            return stream
                    .filter(byCountry())
                    .map(getCovidStatFunction())
                    .sorted(Collections.reverseOrder(Comparator.comparing(CovidStat::getCases)))
                    .limit(3)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

    }

    private Predicate<String> byCountry() {
        return a -> a.contains(SELECTED_COUNTRY);
    }

    private Function<String, CovidStat> getCovidStatFunction() {
        return a -> {
            String[] parts = a.split(",");
            return new CovidStat(parts[POS_OF_YEAR_WEEK], parts[POS_OF_CASES]);
        };
    }

    public static void main(String[] args) {

        CovidStatistic covidStatistic = new CovidStatistic();

        System.out.println(covidStatistic.covidStat(Path.of("data.csv")));
    }

}

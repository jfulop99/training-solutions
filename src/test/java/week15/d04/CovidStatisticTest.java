package week15.d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CovidStatisticTest {

    @Test
    void covidStat() {

        CovidStatistic covidStatistic = new CovidStatistic();

        List<CovidStat> result = List.of(
                new CovidStat("2020-48", "39170"),
                new CovidStat("2020-49", "37026"),
                new CovidStat("2020-46", "32678")
        );

        assertEquals(result, covidStatistic.covidStat(Path.of("data.csv")));
    }
}
package week08.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountyStatisticTest {

    private CountyStatistic countyStatistic;

    @BeforeEach
    void setUp() {
        countyStatistic = new CountyStatistic();
        countyStatistic.readDataFile("countries.txt");
    }

    @Test
    void fileReadTest(){
        assertEquals(11, countyStatistic.getCountries().size());
    }

    @Test
    void maxPopulationTest() {
        assertEquals("Kongoi_Demokratikus_Koztarsasag", countyStatistic.maxPopulaton().getName());
    }

    @Test
    void immutableTest() {
        countyStatistic.getCountries().add(new Country("Teszt", 1, 1,1));
        assertEquals(11, countyStatistic.getCountries().size());
    }

}
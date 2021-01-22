package week12.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CovidCounterTest {

    @Test
    void getNumberOfCovidWords() {

        assertEquals(7, new CovidCounter().getNumberOfCovidWords());

    }
}
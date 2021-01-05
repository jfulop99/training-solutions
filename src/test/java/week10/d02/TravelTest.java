package week10.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    @Test
    void getStopWithMax() {

        assertEquals(8, new Travel().getStopWithMax(Travel.class.getResourceAsStream("utasadat.txt")));

    }
}
package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    @Test
    void createTest() {
        Bottle bottle = Bottle.of(BottleType.GLASS_BOTTLE);
        assertEquals(BottleType.GLASS_BOTTLE, bottle.getType());
    }

    @Test
    void fillTest() {
        Bottle bottle = Bottle.of(BottleType.GLASS_BOTTLE);
        bottle.fill(500);
        assertEquals(500, bottle.getFilledUntil());
    }

    @Test
    void fillOverloadTest() {
        Bottle bottle = Bottle.of(BottleType.PET_BOTTLE);
        bottle.fill(500);
        assertEquals(500, bottle.getFilledUntil());
        Exception e = assertThrows(IllegalArgumentException.class, () -> bottle.fill(2000));
        assertEquals("Too much", e.getMessage());
        assertEquals(500,bottle.getFilledUntil());

    }
}
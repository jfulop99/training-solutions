package week12.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    private House house1 = new House(5, 10, "P");


    @Test
    void testGetHouseNumber() {
        assertEquals(5, house1.getHouseNumber());
    }

    @Test
    void testGetWidth() {
        assertEquals(10, house1.getWidth());
    }

    @Test
    void testGetColorOfHedge() {
        assertEquals("P", house1.getColorOfHedge());
    }

    @Test
    void testCompareTo() {
        assertTrue( 0 > house1.compareTo(new House(7, 20, "K")));
    }

    @Test
    void testToString1() {
        assertEquals("(5)PPPPPPPPPP", house1.toString());
    }

    @Test
    void testThrowIfInvalidNumber() {
        Exception e = assertThrows(IllegalArgumentException.class, ()->new House(0,10,"A"));
        assertEquals("Must be greater than 0", e.getMessage());
    }

    @Test
    void testThrowIfInvalidWidth() {
        Exception e = assertThrows(IllegalArgumentException.class, ()->new House(5,-20,"A"));
        assertEquals("Must be positive", e.getMessage());
    }

    @Test
    void testThrowIfInvalidColor() {
        Exception e = assertThrows(IllegalArgumentException.class, ()->new House(5,10,"$"));
        assertEquals("Must be A-Z, :, #", e.getMessage());
    }
}
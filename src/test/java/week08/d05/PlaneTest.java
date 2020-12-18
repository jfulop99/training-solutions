package week08.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void planeTest() {
        Plane plane = new Plane();

        assertEquals(16, plane.readMap("map.txt"));

    }

}
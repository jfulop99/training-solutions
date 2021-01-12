package week11.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void testPairs() {

        PairFinder pairFinder = new PairFinder();
        assertEquals(3, pairFinder.findPairs(new int[]{7, 1, 5, 7, 3, 3, 9, 7, 6, 7}));
        assertEquals(3, pairFinder.findPairs2(new int[]{7, 1, 5, 7, 3, 3, 9, 7, 6, 7}));

    }

}
package week11.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    void countChars() {

        assertEquals(2, CharCounter.countChars(new String[]{"aaaabc", "cba", "abb"}));

    }

    @Test
    void countChars2() {

        assertEquals(2, CharCounter.countChars2(new String[]{"abaac", "cba", "abb"}));

    }

    @Test
    void countChars3() {

        assertEquals(2, CharCounter.countChars3(new String[]{"abca", "bcbac", "abb"}));

    }
}
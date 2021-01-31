package week13.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharCounterTest {

    @Test
    void counter() {

        assertEquals(7, new CharCounter().counter("+-ab--C:::dEÁÁfg;;;"));

    }
}
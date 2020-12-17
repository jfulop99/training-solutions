package week08.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadMoodTest {

    @Test
    void babMoodTest() {
    BadMood badMood = new BadMood();

    assertEquals(3, badMood.giveMark());

    }

}
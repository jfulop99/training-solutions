package week08.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodMoodTest {

    @Test
    void goodMoodTest() {
        GoodMood goodMood = new GoodMood();

        assertEquals(5, goodMood.giveMark());
    }

}
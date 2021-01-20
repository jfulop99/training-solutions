package week12.d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberStatTest {

    @Test
    void findNumber() {

        assertEquals(3, new NumberStat().findNumber(Arrays.asList(1,1,5,3,4,5,6,5,6,4,1,6,5,4)));

    }
}
package week07.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitSumTest {

    @Test
    void testSumOfDigit() {

        assertEquals(6, DigitSum.sumOfDigits(123));
        assertEquals(6, DigitSum.sumOfDigits2(123));
        assertEquals(6, DigitSum.sumOfDigits3(123));

        assertEquals(15, DigitSum.sumOfDigits(12345));
        assertEquals(15, DigitSum.sumOfDigits2(12345));
        assertEquals(15, DigitSum.sumOfDigits3(12345));
    }

}
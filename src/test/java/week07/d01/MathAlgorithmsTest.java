package week07.d01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    void testWithPrimeNumbers() {
        List<Integer> primeNumbers = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
        boolean result = true;
        for (Integer i:primeNumbers) {
            result = result && MathAlgorithms.isPrime(i);
        }
        assertTrue(result);
    }

    @Test
    void testWithNonPrimeNumbers() {
        List<Integer> primeNumbers = new ArrayList<>(Arrays.asList(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 28, 98, 99));
        boolean result = false;
        for (Integer i:primeNumbers) {
            result = result || MathAlgorithms.isPrime(i);
        }
        assertFalse(result);

    }

    @Test
    void testWithWrongInput() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.isPrime(1));
        assertEquals("Nem megfelelő paraméter! x=1", e.getMessage());

    }

}
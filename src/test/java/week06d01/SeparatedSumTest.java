package week06d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    @Test
    void sum() {
        SeparatedSum separatedSum = new SeparatedSum();
        ResultSeparatedSum result = separatedSum.sum("1,23;2,34;-1,23;-2,34;3;-3");
        assertEquals("6.57 -6.57", result.getPositiveSum() + " " + result.getNegativeSum());
    }

    @Test
    void sumWithWrongInput() {
        SeparatedSum separatedSum = new SeparatedSum();
        Exception e = assertThrows(IllegalArgumentException.class, () -> separatedSum.sum("1.23;2,34;-1,23;-2,34"));
        assertEquals("There is an error in input string!", e.getMessage());
    }

    @Test
    void sumWithNull() {
        SeparatedSum separatedSum = new SeparatedSum();
        Exception e = assertThrows(IllegalArgumentException.class, () -> separatedSum.sum(null));
        assertEquals("Input list is null or blank", e.getMessage());
    }
    @Test
    void sumWithBlank() {
        SeparatedSum separatedSum = new SeparatedSum();
        Exception e = assertThrows(IllegalArgumentException.class, () -> separatedSum.sum("    "));
        assertEquals("Input list is null or blank", e.getMessage());
    }
}
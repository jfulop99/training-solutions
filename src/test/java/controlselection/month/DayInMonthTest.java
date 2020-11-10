package controlselection.month;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DayInMonthTest {
    @Test
    public void testNumberOfDays() {
        assertEquals(31, new DayInMonth().dayInMonth(2017, "május"));
        assertEquals(30, new DayInMonth().dayInMonth(2017, "június"));
        assertEquals(28, new DayInMonth().dayInMonth(2017, "február"));
        assertEquals(28, new DayInMonth().dayInMonth(1900, "február"));
    }

    @Test
    public void testCase() {
        assertEquals(31, new DayInMonth().dayInMonth(2017, "MáJuS"));
    }

    @Test
    public void testLeapYear() {
        assertEquals(29, new DayInMonth().dayInMonth(2012, "február"));
    }

    @Test
    public void testIllegalMonth() {
        assertThrows(IllegalArgumentException.class, () -> new DayInMonth().dayInMonth(2012, "abc"));
    }
}
